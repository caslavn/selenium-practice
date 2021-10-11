package test;

import login.LoginPF;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileReader;
import java.io.IOException;

public class TestPF {

    WebDriver driver;
    LoginPF objLogin;
    PageOne objPageOne;
    PageTwo objPageTwo;
    PageThree objPageThree;
    PageFour objPageFour;
    PageFive objPageFive;
    PageSix objPageSix;
    PageSeven objPageSeven;
    PageEight objPageEight;

    @BeforeTest
    public void setup() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromerdriver");
        /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");*/
        driver = new ChromeDriver();
        driver.get("https://www.schulung.simap.ch/shabforms/COMMON/login/login.jsf?view=3&GO=Projectmanager");
    }

    @Test(dataProvider="dp")
    public void testForm(String datas) {
        String jsonObj[]=datas.split(",");

        objLogin = new LoginPF(driver);
        objLogin.loginToSimap("olmero-test", "jbZVF659aNYrkMp");

        objPageOne = new PageOne(driver);
        objPageOne.fillInPageOne(jsonObj[0], jsonObj[1], jsonObj[2], jsonObj[3], jsonObj[4] );

        objPageTwo = new PageTwo(driver);
        objPageTwo.fillInPageTwo(jsonObj[5], jsonObj[6], jsonObj[7], jsonObj[8], jsonObj[9], jsonObj[10], jsonObj[11],
                jsonObj[12], jsonObj[13], jsonObj[14], jsonObj[16]);
        if (jsonObj[14].equalsIgnoreCase("DATE")) {
            objPageTwo.fillInDeadlineDate(jsonObj[15]);
        }
        if (jsonObj[14].equalsIgnoreCase("DAYS")) {
            objPageTwo.fillInDeadlineDays(jsonObj[57]);
        }
        if (jsonObj[13].equalsIgnoreCase("DOC")) {
            objPageTwo.fillInAddressInfo(jsonObj[40], jsonObj[41], jsonObj[42], jsonObj[43], jsonObj[44], jsonObj[45]);
        }
        objPageTwo.goToPage3();

        objPageThree = new PageThree(driver);
        if (jsonObj[1].equalsIgnoreCase("WORKS")) {
            objPageThree.fillConstruction(jsonObj[39]);
        }
        if (jsonObj[1].equalsIgnoreCase("SUPPLIES")) {
            objPageThree.fillSupply(jsonObj[46]);
        }
        objPageThree.fillInPageThree(jsonObj[17], jsonObj[18]);

        objPageFour = new PageFour(driver);
        if (jsonObj[18].equals("NO") || jsonObj[18].equals("NOT_SPECIFIED")) {
            objPageFour.fillCaseOne(jsonObj[22], jsonObj[25], jsonObj[26]);
            if (jsonObj[22].equalsIgnoreCase("DATE")) {
                objPageFour.fillInTimeFrameDate(jsonObj[23], jsonObj[24]);
            }
            if (jsonObj[22].equalsIgnoreCase("PERIOD")) {
                objPageFour.fillInTimeFrameMonths(jsonObj[58]);
            }
        }
        if (jsonObj[18].equals("YES") || jsonObj[18].equals("NOT_SPECIFIED")) {
            objPageFour.fillCaseTwo(jsonObj[47]);
            if (jsonObj[47].equalsIgnoreCase("MAX")) {
                objPageFour.fillMaxCount(jsonObj[48]);
            }
        }
        objPageFour.fillInPageFour(jsonObj[19], jsonObj[20], jsonObj[21]);

        objPageFive = new PageFive(driver);
        objPageFive.fillPageFive(jsonObj[27], jsonObj[28]);
        if (jsonObj[18].equalsIgnoreCase("NO")) {
            objPageFive.fillCase(jsonObj[29]);
            if(jsonObj[29].equalsIgnoreCase("DATE")) {
                objPageFive.fillInContDate(jsonObj[30], jsonObj[31]);
            }
            if (jsonObj[29].equalsIgnoreCase("PERIOD")) {
                objPageFive.fillInContMonths(jsonObj[59]);
            }
            objPageFive.openPage6First();
        }
        else {
            objPageFive.openPage6Second();
        }

        objPageSix = new PageSix(driver);
        objPageSix.fillInPageSix(jsonObj[32], jsonObj[33]);

        objPageSeven = new PageSeven(driver);
        objPageSeven.fillInPageSeven();

        objPageEight = new PageEight(driver);
        objPageEight.fillInPageEight(jsonObj[37]);

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
            String simapValue = (String) data.get("OB01.COND.DOC.SIMAP-VALUE");
            String proceduresForAppeal = (String) data.get("OB01.INFO.LEGAL");
            String construction = (String) data.get("CONT.WORK.TYPE-TYPE");
            String addressName = (String) data.get("AUTH.SEND-AUTH.NAME");
            String addressStreet = (String) data.get("AUTH.SEND-ADDRESS-STREET");
            Long addressZip = (Long) data.get("AUTH.SEND-ADDRESS-ZIPCODE");
            String addressCity = (String) data.get("AUTH.SEND-ADDRESS-CITY");
            String addressCountry = (String) data.get("AUTH.SEND-ADDRESS-COUNTRY");
            String addressEmail = (String) data.get("AUTH.SEND-ADDRESS-EMAIL");
            String supplyOrderType = (String) data.get("CONT.SUPP.TYPE-TYPE");
            String offersPossibleFor = (String) data.get("LOT.SUBMIT-TO");
            Long maxCount = (Long) data.get("LOT.SUBMIT-MAXCOUNT");
            Long cpvList2 = (Long) data.get("LOT.CPV.LIST_1");
            String descr2 = (String) data.get("LOT.DESCR_1") ;
            String lotTimeFrame = (String) data.get("LOT.TIMEFRAME-RADIO");
            String lotStartDate = (String) data.get("LOT.TIMEFRAME-DATE.START_1");
            String lotEndDate = (String) data.get("LOT.TIMEFRAME-DATE.END_1");
            String lotRenewal = (String) data.get("LOT.RENEWAL-RADIO");
            String lotOption = (String) data.get("LOT.OPTION-RADIO");
            String lotAwardCriteria = (String) data.get("LOT.AWARD.CRITERIA-VALUE");
            Long days = (Long) data.get("OB01.COND.SEND.DEADLINE.DAYS");
            Long timeFrameMonths = (Long) data.get("TIMEFRAME-MONTHS");
            Long contMonths = (Long) data.get("CONT.MONTHS");
            String addressValue = (String) data.get("OB01.COND.DOC.ADDRESS-VALUE");


            arr[i] = fileReference+","+typeOfOrder+","+typeOfProcedure+","+scopeOfInternationalTreaties+
                    ","+desiredDateOfPublication+","+contractingAuthority+","+canton+
                    ","+organizer+","+addressOfCA+","+postalCodeOfCA+","+city+","+countryOfCA+
                    ","+emailOfCA+","+addressForSendingOffers+","+date+","+submittingDeadline+
                    ","+dateOfTheOpeningOfBids+","+projectTitle+","+divisionIntoLots+","+cpv+
                    ","+subjectAndScopeOfTheContract+ ","+locationOfImplementation+","+duration+
                    ","+startDate+","+endDate+","+options+","+awardCriteria+","+willBeAccepted+
                    ","+partialOffersPermitted+","+contDeadlineRadio+","+implementationDateStart+
                    ","+implementationDateEnd+","+eligibilityCriteria+","+evidenceRequired+
                    ","+languagesOffers+","+languageProcedure+","+simapValue+
                    ","+proceduresForAppeal+","+construction+","+addressName+","+addressStreet+
                    ","+addressZip+","+addressCity+","+addressCountry+","+addressEmail+","+supplyOrderType+
                    ","+offersPossibleFor+","+maxCount+","+cpvList2+","+descr2+","+lotTimeFrame+
                    ","+lotStartDate+","+lotEndDate+","+lotRenewal+","+lotOption+","+lotAwardCriteria+","+days+
                    ","+timeFrameMonths+","+contMonths+","+addressValue;
        }

        return arr;

    }

}
