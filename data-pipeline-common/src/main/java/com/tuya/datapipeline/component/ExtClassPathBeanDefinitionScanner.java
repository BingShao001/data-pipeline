package com.yb.datapipeline.component;

import com.yb.datapipeline.annotition.Ext;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author: xie fei
 */
public class ExtClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public ExtClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    /**
     * 注册条件过滤器，将@AddBean注解加入允许扫描的过滤器中，如果加入排除扫描的过滤器集合excludeFilter中，则不会扫描
     **/
    protected void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(Ext.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}