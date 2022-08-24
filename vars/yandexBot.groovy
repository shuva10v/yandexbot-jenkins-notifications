def YANDEX_BOT_URL = "https://botapi.messenger.yandex.net/bot/v1/messages/sendText/"
def BOT_TOKEN_CREDNTIALS_ID = "yandexbot_token"
import groovy.json.JsonBuilder

def send(chat_id, message, botUrl=YANDEX_BOT_URL, credentialsId=BOT_TOKEN_CREDNTIALS_NAME) {
  println("Sending yandex bot message: ${message}")
  withCredentials([string(credentialsId: credentialsName, variable: 'YANDEX_BOT_TOKEN')]) {
    def request = [
      chat_id: chat_id,
      text: message
    ]
    httpRequest url: botUrl, requestBody: new JsonBuilder(request).toString(), httpMode: 'POST', customHeaders: [
            [name: 'content-type', value: 'application/json'],
            [name: 'Authorization', value: "OAuth ${YANDEX_BOT_TOKEN}"]
    ]
  }
}