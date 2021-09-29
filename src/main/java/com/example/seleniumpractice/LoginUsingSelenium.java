package com.example.seleniumpractice;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class LoginUsingSelenium {

    static final Logger logger = LogManager.getLogger(LoginUsingSelenium.class);

    @Test(dataProvider="dp")
    public void login(String datas) {

        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        String jsonObj[]=datas.split(",");
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromerdriver");
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");*/
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.schulung.simap.ch/shabforms/COMMON/login/login.jsf?view=3&GO=Projectmanager");

        WebElement username = driver.findElement(By.id("userlogin"));
        WebElement password = driver.findElement(By.id("userpwd"));
        WebElement login = driver.findElement(By.name("command"));
        username.sendKeys("olmero-test");
        password.sendKeys("jbZVF659aNYrkMp");
        login.click();

      /*  WebElement english = driver.findElement(By.xpath("//*[@id=\"langSelect\"]/a[3]"));
        english.click();*/

        WebElement newTender = driver.findElement(By.xpath("//*[@id=\"Formcontent\"]/form/div[2]/div[2]/table/tbody/tr[1]/td[1]/b/a"));
        newTender.click();

        WebElement fileReference=driver.findElement(By.id("NOTICE.REF"));
        WebElement desiredDateOfPublication=driver.findElement(By.id("cal-field-SIMAP.PUB.DATE"));
        fileReference.sendKeys(jsonObj[0]);
        if(jsonObj[0].equals("")) {
            logger.error("File reference can not be null!");
            throw new RuntimeException("File reference can not be null!");
        }
        List<WebElement> RadioButtonOrder = driver.findElements(By.name("OB.CONT.TYPE"));
        for(int i=0; i < RadioButtonOrder.size(); i++)
        {
            String val = RadioButtonOrder.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[1]))
            {
                RadioButtonOrder.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonProcedure = driver.findElements(By.name("OB.PROC"));
        for(int i=0; i < RadioButtonProcedure.size(); i++)
        {
            String val = RadioButtonProcedure.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[2]))
            {
                RadioButtonProcedure.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonScope = driver.findElements(By.name("OB.WTO"));
        for(int i=0; i < RadioButtonScope.size(); i++)
        {
            String val = RadioButtonScope.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[3]))
            {
                RadioButtonScope.get(i).click();
                break;
            }
        }

        desiredDateOfPublication.sendKeys(jsonObj[4]);
        if(jsonObj[4].equals("")) {
            logger.error("Desired date of publication can not be null!");
            throw new RuntimeException("Desired date of publication can not be null!");
        }
        WebElement page2=driver.findElement(By.xpath("//*[@id=\"Formcontent\"]/div[2]/div[4]/span/a"));
        page2.click();

        WebElement page2Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page2Check.getText(), "Schritt 2")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("First page done!");

        WebElement contractingAuthority=driver.findElement(By.id("AUTH.CONTACT-AUTH.DEMAND"));
        WebElement canton=driver.findElement(By.id("AUTH.CONTACT-AUTH.CANTONCODE"));
        WebElement organizer=driver.findElement(By.id("AUTH.CONTACT-AUTH.NAME"));
        WebElement addressOfCA=driver.findElement(By.id("AUTH.CONTACT-ADDRESS-STREET"));
        WebElement postalCodeOfCA=driver.findElement(By.id("AUTH.CONTACT-ADDRESS-ZIPCODE"));
        WebElement city=driver.findElement(By.id("AUTH.CONTACT-ADDRESS-CITY"));
        WebElement countryOfCA=driver.findElement(By.id("AUTH.CONTACT-ADDRESS-COUNTRY"));
        WebElement emailOfCA=driver.findElement(By.id("AUTH.CONTACT-ADDRESS-EMAIL"));
        WebElement submittingDeadline=driver.findElement(By.id("cal-field-OB01.COND.SEND.DEADLINE.DATE"));
        WebElement dateOfTheOpeningOfBids=driver.findElement(By.id("cal-field-OB01.COND.OFFER.OPEN.DATE"));
        contractingAuthority.sendKeys(jsonObj[5]);
        if(jsonObj[5].equals("")) {
            logger.error("Contracting authority can not be null!");
            throw new RuntimeException("Contracting authority can not be null!");
        }
        organizer.sendKeys(jsonObj[7]);
        if(jsonObj[7].equals("")) {
            logger.error("Organizer can not be null!");
            throw new RuntimeException("Organizer can not be null!");
        }
        addressOfCA.sendKeys(jsonObj[8]);
        if(jsonObj[8].equals("")) {
            logger.error("Address of CA can not be null!");
            throw new RuntimeException("Address of CA can not be null!");
        }
        postalCodeOfCA.sendKeys(jsonObj[9]);
        if(jsonObj[9].equals("")) {
            logger.error("Postal code of CA can not be null!");
            throw new RuntimeException("Postal code of CA can not be null!");
        }
        city.sendKeys(jsonObj[10]);
        if(jsonObj[10].equals("")) {
            logger.error("City can not be null!");
            throw new RuntimeException("City can not be null!");
        }
        countryOfCA.sendKeys(jsonObj[11]);
        if(jsonObj[11].equals("")) {
            logger.error("Country of CA can not be null!");
            throw new RuntimeException("Country of CA can not be null!");
        }
        emailOfCA.sendKeys(jsonObj[12]);
        if(jsonObj[12].equals("")) {
            logger.error("Email can not be null!");
            throw new RuntimeException("Email can not be null!");
        }
        List<WebElement> RadioButtonAddress = driver.findElements(By.name("AUTH.SEND-TYPE"));
        for(int i=0; i < RadioButtonAddress.size(); i++)
        {
            String val = RadioButtonAddress.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[13]))
            {
                RadioButtonAddress.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonDeadline = driver.findElements(By.name("OB01.COND.SEND.DEADLINE-RADIO"));
        for(int i=0; i < RadioButtonDeadline.size(); i++)
        {
            String val = RadioButtonDeadline.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[14]))
            {
                RadioButtonDeadline.get(i).click();
                break;
            }
        }
        submittingDeadline.sendKeys(jsonObj[15]);
        if(jsonObj[15].equals("")) {
            logger.error("Submitting dead line can not be null!");
            throw new RuntimeException("Submitting dead line can not be null!");
        }
        dateOfTheOpeningOfBids.sendKeys(jsonObj[16]);
        if(jsonObj[16].equals("")) {
            logger.error("Date of the opening of bids can not be null!");
            throw new RuntimeException("Date of the opening of bids can not be null!");
        }
        Select cantonDropDown = new Select(canton);
        cantonDropDown.selectByVisibleText(jsonObj[6]);
        if(jsonObj[6].equals("")) {
            logger.error("Canton is not selected!");
            throw new RuntimeException("Canton is not selected!");
        }
        WebElement page3=driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[4]/input[2]"));
        page3.click();

        WebElement page3Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page3Check.getText(), "Schritt 3")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Second page done!");

        WebElement projectTitle=driver.findElement(By.id("CONT.NAME"));
        List<WebElement> RadioButtonConstruction = driver.findElements(By.name("CONT.WORK.TYPE-TYPE"));
        for(int i=0; i < RadioButtonConstruction.size(); i++)
        {
            String val = RadioButtonConstruction.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[37]))
            {
                RadioButtonConstruction.get(i).click();
                break;
            }
        }
        projectTitle.sendKeys(jsonObj[17]);
        if(jsonObj[17].equals("")) {
            logger.error("Project title can not be null!");
            throw new RuntimeException("Project title can not be null!");
        }
        List<WebElement> RadioButtonDivision = driver.findElements(By.name("DIVISION.INTO.LOT"));
        for(int i=0; i < RadioButtonDivision.size(); i++)
        {
            String val = RadioButtonDivision.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[18]))
            {
                RadioButtonDivision.get(i).click();
                break;
            }
        }
        WebElement page4=driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[4]/input[2]"));
        page4.click();

        WebElement page4Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page4Check.getText(), "Schritt 4")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Third page done!");

        WebElement cpv=driver.findElement(By.id("CONT.CPV.LIST"));
        WebElement subjectAndScopeOfTheContract=driver.findElement(By.id("CONT.DESCR"));
        WebElement locationOfImplementation=driver.findElement(By.id("CONT.LOC"));
        WebElement dateStart=driver.findElement(By.id("cal-field-TIMEFRAME-DATE.START"));
        WebElement dateEnd=driver.findElement(By.id("cal-field-TIMEFRAME-DATE.END"));
        cpv.sendKeys(jsonObj[19]);
        if(jsonObj[19].equals("")) {
            logger.error("CPV can not be null!");
            throw new RuntimeException("CPV can not be null!");
        }

        subjectAndScopeOfTheContract.sendKeys(jsonObj[20]);
        if(jsonObj[20].equals("")) {
            logger.error("Subject and scope of the contract can not be null!");
            throw new RuntimeException("Subject and scope of the contract can not be null!");
        }
        locationOfImplementation.sendKeys(jsonObj[21]);
        if(jsonObj[21].equals("")) {
            logger.error("Location of implementation can not be null!");
            throw new RuntimeException("Location of implementation can not be null!");
        }
        List<WebElement> RadioButtonDuration = driver.findElements(By.name("TIMEFRAME-RADIO"));
        for(int i=0; i < RadioButtonDuration.size(); i++)
        {
            String val = RadioButtonDuration.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[22]))
            {
                RadioButtonDuration.get(i).click();
                break;
            }
        }
        dateStart.sendKeys(jsonObj[23]);
        if(jsonObj[23].equals("")) {
            logger.error("Start date can not be null!");
            throw new RuntimeException("Start date can not be null!");
        }
        dateEnd.sendKeys(jsonObj[24]);
        if(jsonObj[24].equals("")) {
            logger.error("End date can not be null!");
            throw new RuntimeException("End date can not be null!");
        }
        List<WebElement> RadioButtonOptions = driver.findElements(By.name("OPTION-RADIO"));
        for(int i=0; i < RadioButtonOptions.size(); i++)
        {
            String val = RadioButtonOptions.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[25]))
            {
                RadioButtonOptions.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonAward = driver.findElements(By.name("AWARD.CRITERIA-VALUE"));
        for(int i=0; i < RadioButtonAward.size(); i++)
        {
            String val = RadioButtonAward.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[26]))
            {
                RadioButtonAward.get(i).click();
                break;
            }
        }
        WebElement page5=driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[3]/input[2]"));
        page5.click();

        WebElement page5Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page5Check.getText(), "Schritt 5")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Fourth page done!");


        WebElement implementationDateStart=driver.findElement(By.id("cal-field-CONT.DATE.START"));
        WebElement implementationDateEnd=driver.findElement(By.id("cal-field-CONT.DATE.END"));
        List<WebElement> RadioButtonVariants = driver.findElements(By.name("CONT.VARIANTS"));
        for(int i=0; i < RadioButtonVariants.size(); i++)
        {
            String val = RadioButtonVariants.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[27]))
            {
                RadioButtonVariants.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonPartials = driver.findElements(By.name("CONT.PARTIALS"));
        for(int i=0; i < RadioButtonPartials.size(); i++)
        {
            String val = RadioButtonPartials.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[28]))
            {
                RadioButtonPartials.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonContDeadline = driver.findElements(By.name("CONT.DEADLINE-RADIO"));
        for(int i=0; i < RadioButtonContDeadline.size(); i++)
        {
            String val = RadioButtonContDeadline.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[29]))
            {
                RadioButtonContDeadline.get(i).click();
                break;
            }
        }
        implementationDateStart.sendKeys(jsonObj[30]);
        if(jsonObj[30].equals("")) {
            logger.error("Start date of implementation can not be null!");
            throw new RuntimeException("Start date of implementation can not be null!");
        }
        implementationDateEnd.sendKeys(jsonObj[31]);
        if(jsonObj[31].equals("")) {
            logger.error("End date of implementation can not be null!");
            throw new RuntimeException("End date of implementation can not be null!");
        }
        WebElement page6=driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[5]/input[2]"));
        page6.click();

        WebElement page6Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page6Check.getText(), "Schritt 6")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Fifth page done!");

        List<WebElement> RadioButtonEligCriteria = driver.findElements(By.name("OB01.COND.TECHNICAL-VALUE"));
        for(int i=0; i < RadioButtonEligCriteria.size(); i++)
        {
            String val = RadioButtonEligCriteria.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[32]))
            {
                RadioButtonEligCriteria.get(i).click();
                break;
            }
        }
        List<WebElement> RadioButtonEvidence = driver.findElements(By.name("OB01.COND.PROOF-VALUE"));
        for(int i=0; i < RadioButtonEvidence.size(); i++)
        {
            String val = RadioButtonEvidence.get(i).getAttribute("value");
            if (val.equalsIgnoreCase(jsonObj[33]))
            {
                RadioButtonEvidence.get(i).click();
                break;
            }
        }

        WebElement germanOffers = driver.findElement(By.name("LANGUAGE.EC-DE"));
        WebElement offersLanguage = driver.findElement(By.name("LANGUAGE.EC-EN"));
       // WebElement offersLanguage = driver.findElement(By.name(jsonObj[34]));
        WebElement germanProcedure = driver.findElement(By.name("LANGUAGE.PROC.EC-DE"));
        WebElement procedureLanguage = driver.findElement(By.name("LANGUAGE.PROC.EC-EN"));
       // WebElement procedureLanguage = driver.findElement(By.name(jsonObj[35]));
        germanOffers.click();
        offersLanguage.click();
        germanProcedure.click();
        procedureLanguage.click();

        WebElement page7 = driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[6]/input[2]"));
        page7.click();

        WebElement page7Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page7Check.getText(), "Schritt 7")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Sixth page done!");

        WebElement tenderingDocumentationSource=driver.findElement(By.id("OB01.COND.DOC.SIMAP-VALUE"));
        tenderingDocumentationSource.click();
        WebElement page8 = driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[6]/input[2]"));
        page8.click();

        WebElement page8Check = driver.findElement(By.className("orange"));
        if(!Objects.equals(page8Check.getText(), "Schritt 8")) {
            String errormsg = driver.findElement(By.className("fieldsetErrorMsg")).getText();
            if (errormsg != "") {
                logger.error(errormsg);
                throw new RuntimeException(errormsg);
            }
        }
        else logger.info("Seventh page done!");

        WebElement proceduresForAppeal = driver.findElement(By.id("OB01.INFO.LEGAL"));
        proceduresForAppeal.sendKeys(jsonObj[37]);
        if(jsonObj[37].equals("")) {
            logger.error("Procedures for appeal can not be null!");
            throw new RuntimeException("Procedures for appeal can not be null!");
        }

        WebElement done = driver.findElement(By.xpath("//*[@id=\"formShab\"]/div[1]/div[4]/input[2]"));
        done.click();

        WebElement doneFormCheck = driver.findElement(By.className("created"));
        if(!doneFormCheck.isDisplayed()) {

                logger.error("Form is not successfully completed.");
                throw new RuntimeException("Form is not successfully completed.");
            }

        else logger.info("Form successfully completed!");

    }


        @DataProvider(name="dp")
        public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/home/dev987/IdeaProjects/selenium-practice/jsonfiles/simap.json");

        Object obj = jsonParser.parse(reader);

        JSONObject jsonObj = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObj.get("form");

        String arr[] = new String[jsonArray.size()];

        for (int i=0; i<jsonArray.size(); i++)
        {
            JSONObject data = (JSONObject) jsonArray.get(i);
            String fileReference = (String) data.get("NOTICE.REF");
            String typeOfOrder = (String) data.get("OB.CONT.TYPE");
            String typeOfProcedure = (String) data.get("OB.PROC");
            String scopeOfInternationalTreaties = (String) data.get("OB.WTO");
            String desiredDateOfPublication = (String) data.get("SIMAP.PUB.DATE");
            String contractingAuthority = (String) data.get("AUTH.CONTACT-AUTH.DEMAND");
            String canton = (String) data.get("AUTH.CONTACT-AUTH.CANTONCODE");
            String organizer = (String) data.get("AUTH.CONTACT-AUTH.NAME");
            String addressOfCA = (String) data.get("AUTH.CONTACT-ADDRESS-STREET");
            Long postalCodeOfCA = (Long) data.get("AUTH.CONTACT-ADDRESS-ZIPCODE");
            String city = (String) data.get("AUTH.CONTACT-ADDRESS-CITY");
            String countryOfCA = (String) data.get("AUTH.CONTACT-ADDRESS-COUNTRY");
            String emailOfCA = (String) data.get("AUTH.CONTACT-ADDRESS-EMAIL");
            String addressForSendingOffers = (String) data.get("AUTH.SEND-TYPE");
            String date = (String) data.get("OB01.COND.SEND.DEADLINE-RADIO");
            String submittingDeadline = (String) data.get("OB01.COND.SEND.DEADLINE.DATE");
            String dateOfTheOpeningOfBids = (String) data.get("OB01.COND.OFFER.OPEN.DATE");
            String projectTitle = (String) data.get("CONT.NAME");
            String divisionIntoLots = (String) data.get("DIVISION.INTO.LOT");
            Long cpv = (Long) data.get("CONT.CPV.LIST");
            String subjectAndScopeOfTheContract = (String) data.get("CONT.DESCR");
            String locationOfImplementation = (String) data.get("CONT.LOC");
            String duration = (String) data.get("TIMEFRAME-RADIO");
            String startDate = (String) data.get("TIMEFRAME-DATE.START");
            String endDate = (String) data.get("TIMEFRAME-DATE.END");
            String options = (String) data.get("OPTION-RADIO");
            String awardCriteria = (String) data.get("AWARD.CRITERIA-VALUE");
            String willBeAccepted = (String) data.get("CONT.VARIANTS");
            String partialOffersPermitted = (String) data.get("CONT.PARTIALS");
            String contDeadlineRadio = (String) data.get("CONT.DEADLINE-RADIO");
            String implementationDateStart = (String) data.get("CONT.DATE.START");
            String implementationDateEnd = (String) data.get("CONT.DATE.END");
            String eligibilityCriteria = (String) data.get("OB01.COND.TECHNICAL-VALUE");
            String evidenceRequired = (String) data.get("OB01.COND.PROOF-VALUE");
            String languagesOffers = (String) data.get("LANGUAGE.EC-EN");
            String languageProcedure = (String) data.get("LANGUAGE.PROC.EC-EN");
            String tenderingDocumentationSource = (String) data.get("OB01.COND.DOC.SIMAP-VALUE");
            String proceduresForAppeal = (String) data.get("OB01.INFO.LEGAL");
            String construction = (String) data.get("CONT.WORK.TYPE-TYPE");


            arr[i] = fileReference+","+typeOfOrder+","+typeOfProcedure+","+scopeOfInternationalTreaties+","+desiredDateOfPublication+","+contractingAuthority+","+canton+","+organizer+","+addressOfCA+","+postalCodeOfCA+","+city+","+countryOfCA+","+emailOfCA+","+addressForSendingOffers+","+date+","+submittingDeadline+","+dateOfTheOpeningOfBids+","+projectTitle+","+divisionIntoLots+","+cpv+","+subjectAndScopeOfTheContract+","+locationOfImplementation+","+duration+","+startDate+","+endDate+","+options+","+awardCriteria+","+willBeAccepted+","+partialOffersPermitted+","+contDeadlineRadio+","+implementationDateStart+","+implementationDateEnd+","+eligibilityCriteria+","+evidenceRequired+","+languagesOffers+","+languageProcedure+","+tenderingDocumentationSource+","+proceduresForAppeal+","+construction;
        }

        return arr;

    }

}
