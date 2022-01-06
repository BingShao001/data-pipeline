package com.yb.datapipeline.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * AutoConfiguredMyBatisRegistrar
 *
 * @author bing
 * @version 1.0
 * @create 05/01/2022
 **/
@Slf4j
public class ExtAutoConfiguredRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, BeanFactoryAware {
    public static final String BASE_PACKAGE = "com.yb.datapipeline";
    private ResourceLoader resourceLoader;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ExtClassPathBeanDefinitionScanner scanner = new ExtClassPathBeanDefinitionScanner(registry, false);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerFilters();
        scanner.doScan(BASE_PACKAGE);
    }


}
