package ru.aplana.demo.reporter;

import gherkin.formatter.model.Result;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.aplana.demo.util.DriverManager;


/**
 * Created by Baykova-MS on 16.01.2018.
 */


public class AllureReporter extends io.qameta.allure.cucumberjvm.AllureCucumberJvm {


    @Override
    public void result(Result result) {
        if (!result.getStatus().equals("passed") && !result.getStatus().equals("skipped")) {
            takeScreenshot();
        }
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Скриншот в момент ошибки")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
