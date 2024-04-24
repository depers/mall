package cn.bravedawn.web.mbg.mapper;

import cn.bravedawn.web.mbg.model.ArticleTagRelation;

public interface ArticleTagRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleTagRelation record);

    int insertSelective(ArticleTagRelation record);

    ArticleTagRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleTagRelation record);

    int updateByPrimaryKey(ArticleTagRelation record);
}