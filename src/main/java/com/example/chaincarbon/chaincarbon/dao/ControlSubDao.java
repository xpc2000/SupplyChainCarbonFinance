package com.example.chaincarbon.dao;

import com.example.chaincarbon.mapper.ControlSubMapper;
import com.example.chaincarbon.model.pojo.ControlSub;
import com.example.chaincarbon.model.pojo.ControlSubExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xpc2000
 * @Date: 2022/03/02
 * @Description: 控排链链属企业的CRUD
 */
@Repository
public class ControlSubDao {

    @Autowired
    ControlSubMapper controlSubMapper;

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String name
     * @Return: ControlSub
     * @Description: 通过主键查找控排链链属企业
     */
    public ControlSub getControlSub(String name){
        try{
            return controlSubMapper.selectByPrimaryKey(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String email
     * @Return: ControlSub
     * @Description: 通过邮箱返回控排链链属企业
     */
    public ControlSub getControlSubByEmail(String email){
        ControlSubExample controlSubExample=new ControlSubExample();
        ControlSubExample.Criteria criteria=controlSubExample.createCriteria();
        criteria.andEmailEqualTo(email);
        try{
            List<ControlSub> list=controlSubMapper.selectByExample(controlSubExample);
            if(list.size()!=0) return list.get(0);
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: ControlSub controlSub
     * @Return: 执行结果
     * @Description: 更新控排链链属企业信息
     */
    public int updateControlSub(ControlSub controlSub){
        int result=0;
        try{
            result=controlSubMapper.updateByPrimaryKey(controlSub);
        } catch (Exception e) {
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    /**
     * @Author: xpc2000
     * @Date: 2022/03/02
     * @Param: String chain
     * @Return: List<ControlSub>
     * @Description: 查找同属一个供应链的控排链链属企业列表
     */
    public List<ControlSub> getControlSubByChain(String chain){
        ControlSubExample controlSubExample=new ControlSubExample();
        ControlSubExample.Criteria criteria=controlSubExample.createCriteria();
        criteria.andControlChainEqualTo(chain);
        try {
            return controlSubMapper.selectByExample(controlSubExample);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
