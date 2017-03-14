# TestAutomation
Maven project for GitHub.com testing

Java + Allure + Selenium

Necessary soft
---
- Google Chrome
- Git
- Maven

Instructions:
---
1. Open console (command prompt)
2. Check for port 8080 available (```netstat -ano```)
3. Clone repository: ```git clone https://github.com/CriticalGnome/TestAutomation.git```
4. Enter TestAutomation folder (```cd TestAutomation```)
5. Start maven with following command: ```mvn clean test site jetty:run```
6. Wait for all tests done
7. When you see ```Started Jetty Server```, you can open Test Results in browser: http://localhost:8080
