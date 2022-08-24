# yandexbot-jenkins-notifications

## Installation

1. Create credentials with bot token with ID ``yandexbot_token``:
![Create token](./yandexbot_token.jpg)
2. Go to Manage Jenkins => Configure System => Global Pipeline Libraries and add
this library as follows:
![Jenkins global library](./jenkins_global_library.jpg)
3. Create test pipeline job like this [example.Jenkinsfile](./example.Jenkinsfile). 
Replace ``CHANNEL_ID_HERE`` from [example.Jenkinsfile](./example.Jenkinsfile) with
real chat id.

## See also

1. [Official Yandex Bot documentation](https://botapi.messenger.yandex.net/docs/)
2. [Extending Jenkins Pipeline with Shared Libraries](https://www.jenkins.io/doc/book/pipeline/shared-libraries/)