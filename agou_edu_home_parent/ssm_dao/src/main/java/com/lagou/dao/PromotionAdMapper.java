package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    public List<PromotionAd> findAllPromotionAdByPage();

    void savePromotionAd(PromotionAd promotionAd);

    void updatePromotionAd(PromotionAd promotionAd);

    /**
     * 根据id查询广告信息
     * */
    PromotionAd findPromotionAdById(int id);

    /*广告上下线*/
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
