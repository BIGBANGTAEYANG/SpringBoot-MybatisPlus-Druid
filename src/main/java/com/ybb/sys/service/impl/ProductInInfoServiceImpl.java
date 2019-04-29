package com.ybb.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ybb.sys.entity.ProductInInfo;
import com.ybb.sys.entity.UserInfo;
import com.ybb.sys.mapper.ProductInInfoMapper;
import com.ybb.sys.service.ProductInInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WQ
 * @since 2019-04-25
 */
@Service
public class ProductInInfoServiceImpl extends ServiceImpl<ProductInInfoMapper, ProductInInfo> implements ProductInInfoService {

    @Override
    public IPage<ProductInInfo> dataTableProductInInfoService(String search, int start, int length, String orderColumnName, String orderSort) {
        QueryWrapper<ProductInInfo> queryWrapper = new QueryWrapper<>();
        IPage<ProductInInfo> page = new Page<>(start,length);
        if(orderSort.equals("asc")){
            queryWrapper.orderByAsc(orderColumnName);
        }else{
            queryWrapper.orderByDesc(orderColumnName);
        }
        queryWrapper.like("productId",search).or().like("productNo",search).or()
                .like("productName",search).or().like("providerName",search).or().like("inDate",search).or().like("expressNo",search);
        return baseMapper.selectPage(page,queryWrapper);
    }
}
