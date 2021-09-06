package com.ktb.juejin.importexample;

import com.ktb.juejin.importexample.config.BarImportSelector;
import com.ktb.juejin.importexample.config.BartenderConfiguration;
import com.ktb.juejin.importexample.config.WaiterRegistrar;
import com.ktb.model.Boss;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({Boss.class, BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class})
public @interface EnableTavern {

}
