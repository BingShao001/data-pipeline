package com.yb.datapipeline.component;


import com.yb.datapipeline.annotition.ExtComponent;
import com.yb.datapipeline.base.BaseExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.yb.datapipeline.constants.BaseConstants.UNDERLINE;

@Component
@Slf4j
public class ExtComponentAutoConfigContainerBean implements BeanPostProcessor {
    @Resource
    private ExtContainer extContainer;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        boolean hasExtComponent = aClass.isAnnotationPresent(ExtComponent.class);
        if (hasExtComponent) {
            Class<?> superclass = aClass.getSuperclass();
            String simpleName = superclass.getSimpleName();
            ExtComponent extComponent = aClass.getAnnotation(ExtComponent.class);
            String extKey = this.getKey(extComponent, simpleName);
            extContainer.addExt(extKey, (BaseExt) bean);
            log.info("load bean : key {} mame {}", extKey, simpleName);
        }
        return bean;
    }

    private String getKey(ExtComponent extComponent, String simpleName) {
        return new StringBuilder(simpleName)
                .append(UNDERLINE)
                .append(extComponent.bizCode())
                .append(UNDERLINE)
                .append(extComponent.subCode())
                .toString();
    }
}
