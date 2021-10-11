package com.example.seleniumpractice.factory;

import com.example.seleniumpractice.pagefactory.SimapLoginFactory;
import com.example.seleniumpractice.repository.ClientRepository;
import com.example.seleniumpractice.service.ClientService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class DatabaseReader implements ReaderOperation {

    WebDriver driver;

    //@Autowired
    SimapLoginFactory simapLoginFactory;

    @Autowired
    ClientRepository clientRepository;

    //@Autowired
    ClientService clientService;

    //@Autowired
    //Client client;

    @Override
    public void read()  {

        System.out.println("Logged in from database.");
        System.out.println("Logged in from json.");


        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.schulung.simap.ch/shabforms/COMMON/login/login.jsf?view=3&GO=Projectmanager");
        simapLoginFactory = new SimapLoginFactory(driver);

        try {
            Class.forName("org.hibernate.dialect.PostgreSQLDialect");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/simap-db","postgres","123");

            PreparedStatement stmt=con.prepareStatement("Select username, password from client where id=1");
            //PreparedStatement stmt1=con.prepareStatement("Select password from client where id=1");

            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                simapLoginFactory.loginToSimapFactory(rs.getString(1), rs.getString("password"));
                //simapLoginFactory.setPassword(rs.getString("password"));
                //simapLoginFactory.setUsername(clientRepository.findOneById(1));
                //simapLoginFactory.setUsername(clientService.getClientUsernameById(1));
                //clientService.getClientById(1);

                simapLoginFactory.clickLogin();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


       // clientService.getClient().forEach(simapLoginFactoryDTO -> {
         //   Client client = new Client();
           // simapLoginFactory.setUsername(client.getUsername());
            //simapLoginFactory.setPassword(client.getPassword());
        //});

        //Client client = new Client();
        //simapLoginFactory.setUsername(clientRepository.findOne());
        //simapLoginFactory.setPassword(client.getPassword());

        //simapLoginFactory.setUsername(clientService.getUsername());
    }
}
