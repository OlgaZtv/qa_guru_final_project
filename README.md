# Автотесты для сайтов

* UI - https://medindex.ru/
* API - https://reqres.in

## Покрыт следующий функционал
* UI тесты - https://medindex.ru/
    * ✅ Проверка наличия формы для отклика соискателей
    * ✅ Проверка переключения страницы сайта на английский язык
    * ✅ Проверка наличия блока с вакансиями на сайте
    * ✅ Проверка правильности заголовка страницы
    * ✅ Проверка, что лог страницы не содержит ошибок
    

* API тесты - https://reqres.in
  * ✅ Получение списка пользователей
  * ✅ Проверка наличия пользователя в базе
  * ✅ Получение одного пользователя
  * ✅ Создание пользователя
  * ✅ Обновление пользователя
  * ✅ Регистрация пользователя
  * ✅ Проверка id и email пользователя
  * ✅ Проверка email пользователя с помощью Groovy

## Технологический стек
Java, Gradle, JUnit5, IntelliJ IDEA, Selenide, Jenkins, Allure TestOps, Jira, Github, Telegram

<p  align="left">
<code>
  <img src="https://i.ibb.co/gtnxLqH/java.png" width="40" height="40"  alt="Java"/>
  <img src="https://i.ibb.co/0jBcyBY/gradle-icon.png" width="40" height="40"  alt="Gradle"/>
  <img src="https://i.ibb.co/PgvTPCh/Junit5.jpg" width="50" height="40"  alt="JUnit 5"/>
  <img src="https://i.ibb.co/8YWqxkP/Intelleji.png" width="40" height="40"  alt="IDEA"/>
  <img src="https://i.ibb.co/SmBNT3B/Selenide.jpg" width="50" height="40"  alt="Seleide"/>
  <img src="https://i.ibb.co/4p3B78k/Jenkins.jpg" width="40" height="40"  alt="Jenkins"/>
  <img src="https://i.ibb.co/37MYfX4/allure.jpg" width="40" height="40"  alt="Allure TestOps"/>
  <img src="https://i.ibb.co/RSv0PZv/Jira.png" width="40" height="40"  alt="Jira"/>
  <img src="https://i.ibb.co/mCQd2Cx/Github.png" width="40" height="40"  alt="Github"/>
  <img src="https://i.ibb.co/KWhp0hT/telegram-logo.png" width="40" height="40"  alt="Telegram"/>
</code>
</p>

## Как запустить
Перед выполением необходимо:
* в local.properies определить параметры конфигурации (для запуска тестов локально)
* в remote.properies определить параметры конфигурации (для запуска тестов удаленно) или передать значения:
    - browser (default chrome)
    - browserVersion (default 89.0)
    - browserSize (default 1920x1080)
    - browserMobileView (mobile device name, for example iPhone X)
    - remoteDriverUrl (url address from selenoid or grid)
    - videoStorage (url address where you should get video)
    - threads (number of threads)

### Локально
```
gradle clean test
```

### Удаленно
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Видео о прохождении тестов
<img src="https://i.ibb.co/93q2DGd/fefcc5cbac5d03c1.gif" alt="video test" border="0" />

### Запуск в Jenkins
Статистика по запускам <br >
<a href="https://ibb.co/TvwPjzj"><img src="https://i.ibb.co/2nFcVXV/jenkins-stst.png" alt="Статистика по запускам" border="0"></a>

Параметры запуска <br >
<a href="https://ibb.co/THr4VDp"><img src="https://i.ibb.co/nDR7HqZ/Jenkins.png" alt="Jenkins" border="0"></a>

### Отчёт о прохождении автотестов в Allure Report
<a href="https://ibb.co/JrXXHGf"><img src="https://i.ibb.co/SVqqBMh/Allure-Report.png" alt="Allure-Report" border="0"></a>
### Список автотестов в Allure Report
<a href="https://ibb.co/wSYB1HD"><img src="https://i.ibb.co/rxvFJPn/Allure-Report-2.png" alt="Allure-Report-2" border="0"></a>
### Хранение тестовой документации в Allure TestOps
<a href="https://ibb.co/7jtSWMC"><img src="https://i.ibb.co/pbj1zVw/Allure-Test-Ops.png" alt="Allure-Test-Ops" border="0"></a>
### Интерграция с Jira
<a href="https://ibb.co/74Mq73C"><img src="https://i.ibb.co/JQ69XYt/HOMEWORK-320-Olga-Ztv-final-project-tests-QA-GURU-Jira.png" alt="HOMEWORK-320-Olga-Ztv-final-project-tests-QA-GURU-Jira" border="0"></a>
### Уведомления о прохождении автотестов в Telegram
<a href="https://imgbb.com/"><img src="https://i.ibb.co/G2fGQj5/telegram-bot.png" alt="telegram-bot" border="0"></a>