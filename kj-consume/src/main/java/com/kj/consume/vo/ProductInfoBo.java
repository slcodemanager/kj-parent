package com.kj.consume.vo;

import com.kj.consume.entity.KProduct;
import com.kj.consume.entity.KProductSpec;

import java.util.List;

/**
 * @author quan
 * @date 2021-01-18 16:04
 */

public class ProductInfoBo extends KProduct {
    private List<SpecVo> specs;
    private List<String> shareImg;
    private List<String> detailImg;

    public List<SpecVo> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecVo> specs) {
        this.specs = specs;
    }

    public List<String> getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(List<String> detailImg) {
        this.detailImg = detailImg;
    }

    public List<String> getShareImg() {

        return shareImg;
    }

    public void setShareImg(List<String> shareImg) {
        this.shareImg = shareImg;
    }
}

