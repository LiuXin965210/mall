package com.lx.mall.mbg.mapper;

import com.lx.mall.mbg.model.PmsProduct;
import com.lx.mall.mbg.model.PmsProductExample;
import com.lx.mall.mbg.model.PmsProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductMapper {
    long countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductWithBLOBs record);

    int insertSelective(PmsProductWithBLOBs record);

    List<PmsProductWithBLOBs> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);

    PmsProductWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductWithBLOBs record, @Param("example") PmsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProductWithBLOBs record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(PmsProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsProductWithBLOBs record);

    int updateByPrimaryKey(PmsProduct record);
}