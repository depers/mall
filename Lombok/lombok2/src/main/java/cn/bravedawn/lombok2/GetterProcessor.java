package cn.bravedawn.lombok2;

import com.google.auto.service.AutoService;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.*;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author : fengx9
 * @Project : lombok2
 * @Date : Created in 2023-11-09 13:51
 */

@SupportedAnnotationTypes("cn.bravedawn.lombok2.Data")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class GetterProcessor extends AbstractProcessor {


    /**
     * AST
     */
    private JavacTrees trees;
    /**
     * 操作修改AST
     */
    private TreeMaker treeMaker;
    /**
     * 符号封装类，处理名称
     */
    private Names names;
    /**
     * 打印信息
     */
    private Messager messager;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        trees = JavacTrees.instance(processingEnv);
        final Context context = ((JavacProcessingEnvironment) processingEnv).getContext();
        treeMaker = TreeMaker.instance(context);
        names = Names.instance(context);
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("begin");
        Set<? extends Element> dataAnnotations = roundEnv.getElementsAnnotatedWith(Data.class);

        dataAnnotations.stream().map(element -> trees.getTree(element)).forEach(
                tree -> tree.accept(new TreeTranslator() {

                    @Override
                    public void visitMethodDef(JCTree.JCMethodDecl jcMethodDecl) {
                        // print method name
                        System.out.println("-------2");
                        messager.printMessage(Diagnostic.Kind.NOTE, jcMethodDecl.toString());
                        super.visitMethodDef(jcMethodDecl);
                    }


                    @Override
                    public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                        System.out.println("-------1");
                        final Map<Name, JCTree.JCVariableDecl> treeMap = jcClassDecl.defs.stream().filter(item -> item.getKind().equals(Tree.Kind.VARIABLE))
                                .map(tree -> (JCTree.JCVariableDecl) tree)
                                .collect(Collectors.toMap(JCTree.JCVariableDecl::getName, Function.identity()));

                        treeMap.forEach((key, var) -> {
                            messager.printMessage(Diagnostic.Kind.NOTE, "var: " + key);
                            System.out.println("-----3");

                            try {
                                // add setter method
                                jcClassDecl.defs = jcClassDecl.defs.prepend(setter(var));

                                // add getter method
                                jcClassDecl.defs = jcClassDecl.defs.prepend(getter(var));

                            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                                e.printStackTrace();
                                messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage());
                            }
                        });
                        super.visitClassDef(jcClassDecl);
                    }
                })

        );

        return true;
    }

    /**
     * 获取驼峰名称
     * @param varName 变量名
     * @param prefix 前缀
     * @return
     */
    private Name getMethodName(Name varName, String prefix) {
        return names.fromString(prefix + varName.toString().substring(0, 1).toUpperCase() + varName.toString().substring(1));
    }


    /**
     * 自定义Setter方法
     * @param var
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private JCTree setter(JCTree.JCVariableDecl var) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 方法级别
        final JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);

        // 方法返回值
        JCTree.JCExpression returnType = treeMaker.Type((Type) (Class.forName("com.sun.tools.javac.code.Type$JCVoidType").newInstance()));

        // 方法名称
        final Name varName = var.getName();
        Name methodName = getMethodName(varName, "set");

        // 方法参数
        final JCTree.JCVariableDecl paramVars = treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER, List.nil()), var.name, var.vartype, null);
        final List<JCTree.JCVariableDecl> params = List.of(paramVars);

        List<JCTree.JCTypeParameter> typeParameters = List.nil();

        List<JCTree.JCExpression> throwClauses = List.nil();

        // 方法体
        ListBuffer<JCTree.JCStatement> jcStatements = new ListBuffer<>();
        jcStatements.append(treeMaker.Exec(treeMaker.Assign(
                treeMaker.Select(treeMaker.Ident(names.fromString("this")), varName),
                treeMaker.Ident(varName)
        )));
        final JCTree.JCBlock block = treeMaker.Block(0, jcStatements.toList());

        // 构造一个新方法，最后一个参数是方法注解的默认值，这里没有设置为null
        return treeMaker.MethodDef(modifiers, methodName, returnType, typeParameters, params, throwClauses, block, null);
    }


    /**
     * 自定义Getter方法
     * @param var
     * @return
     */
    private JCTree getter(JCTree.JCVariableDecl var) {
        // 方法级别
        final JCTree.JCModifiers modifiers = treeMaker.Modifiers(Flags.PUBLIC);

        // 方法名称
        final Name methodName = getMethodName(var.getName(), "get");

        // 方法内容
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        statements.append(treeMaker.Return(treeMaker.Select(treeMaker.Ident(names.fromString("this")), var.getName())));
        final JCTree.JCBlock block = treeMaker.Block(0, statements.toList());

        // 返回值类型
        final JCTree.JCExpression returnType = var.vartype;

        // 没有参数类型
        List<JCTree.JCTypeParameter> typeParameters = List.nil();

        // 没有参数变量
        List<JCTree.JCVariableDecl> params = List.nil();

        // 没有异常
        List<JCTree.JCExpression> throwClauses = List.nil();

        // 构造getter
        return treeMaker.MethodDef(modifiers, methodName, returnType, typeParameters, params, throwClauses, block,
                null);
    }


}
