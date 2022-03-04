package com.example.chaincarbon.mapper;

import com.example.chaincarbon.model.pojo.FinanceInstitution;
import com.example.chaincarbon.model.pojo.FinanceInstitutionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FinanceInstitutionMapper {
    int deleteByPrimaryKey(String companyName);

    int insert(FinanceInstitution record);

    int insertSelective(FinanceInstitution record);

    List<FinanceInstitution> selectByExample(FinanceInstitutionExample example);

    FinanceInstitution selectByPrimaryKey(String companyName);

    int updateByExampleSelective(@Param("record") FinanceInstitution record, @Param("example") FinanceInstitutionExample example);

    int updateByExample(@Param("record") FinanceInstitution record, @Param("example") FinanceInstitutionExample example);

    int updateByPrimaryKeySelective(FinanceInstitution record);

    int updateByPrimaryKey(FinanceInstitution record);
}