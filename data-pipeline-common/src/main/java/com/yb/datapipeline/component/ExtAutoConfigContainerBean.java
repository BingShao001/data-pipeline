package com.yb.datapipeline.component;

import com.yb.datapipeline.annotition.Ext;
import com.yb.datapipeline.base.BaseExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.yb.datapipeline.constants.BaseConstants.UNDERLINE;

@Component
@Slf4j
public class ExtAutoConfigContainerBean implements BeanPostProcessor {
    @Resource
    private ExtContainer extContainer;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        boolean hasExtComponent = aClass.isAnnotationPresent(Ext.class);
        if (hasExtComponent) {
            Class<?> superclass = aClass.getSuperclass();
            String simpleName = superclass.getSimpleName();
            Ext ext = aClass.getAnnotation(Ext.class);
            String extKey = this.getKey(ext, simpleName);
            extContainer.addExt(extKey, (BaseExt) bean);
            log.info("load bean : key {} mame {}", extKey, simpleName);
        }
        return bean;
    }

    private String getKey(Ext ext, String simpleName) {
        return new StringBuilder(simpleName)
                .append(UNDERLINE)
                .append(ext.bizCode())
                .append(UNDERLINE)
                .append(ext.subCode())
                .toString();
    }
}
