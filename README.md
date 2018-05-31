Нужен jdk8 и гугл-хром/хромиум последней версии

для линуксоидов то что нужно выполнить на консоли

<code>./gradlew test -Djirauser=**someuser** -Djirapassword=**yourpassword** -Did1c=**12345** -Dselenide.browser=chrome</code>

для виндузятников то что нужно выполнить на консоли

<code>gradlew.bat test -Djirauser=**someuser** -Djirapassword=**yourpassword** -Did1c=**12345** -Dselenide.browser=chrome</code>

ну тут все просто

**someuser**, **yourpassword**, **12345** заменить на свои

p.s. Если возинкнуть проблемы и хром не стартонул, то можно попробовать запустить через firefox заменив <code>-Dselenide.browser=chrome</code> на <code>-Dselenide.browser=firefox</code>   