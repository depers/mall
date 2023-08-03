package cn.bravedawn.exception.throwexception;


/**
 * 1.ThrowException：在构造函数中添加原始异常，从而保存原始的Exception信息，方便在异常堆栈中打印出来
 * 2.ThrowException2：finally会屏蔽异常
 * 3.ThrowException3：为了避免finally吃掉屏蔽异常，需要手动调用addSuppressed()方法添加屏蔽异常到堆栈中
 */