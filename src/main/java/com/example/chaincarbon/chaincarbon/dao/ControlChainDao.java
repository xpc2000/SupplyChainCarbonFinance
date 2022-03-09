package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.ControlChainMapper;
import com.example.chaincarbon.model.pojo.ControlChain;
import com.example.chaincarbon.model.pojo.ControlChainExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 控排链的CRUD
 */
@Repository
public class ControlChainDao {

    @Autowired
    ControlChainMapper controlChainMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name
     * @Return: ControlChain
     * @Description: 通过名称寻找控排链
     */
    public ControlChain getControlChainByName(String name){
        ControlChainExample controlChainExample=new ControlChainExample();
        ControlChainExample.Criteria criteria=controlChainExample.createCriteria();
        criteria.andNameEqualTo(name);
        try {
            List<ControlChain> list=controlChainMapper.selectByExample(controlChainExample);
            if(list.size()!=0) return list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ControlChain controlChain
     * @Return: 执行结果
     * @Description: 更新控排链信息
     */
    public int updateControlChain(ControlChain controlChain){
        int result=0;
        try {
            result=controlChainMapper.updateByPrimaryKey(controlChain);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }
}
