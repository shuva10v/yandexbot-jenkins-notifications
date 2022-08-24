import groovy.json.JsonBuilder

def send(chat_id, message,
         important=false,
         botUrl="https://botapi.messenger.yandex.net/bot/v1/messages/sendText/",
         credentialsId="yandexbot_token") {
  println("Sending yandex bot message: ${message}")
  withCredentials([string(credentialsId: credentialsId, variable: 'YANDEX_BOT_TOKEN')]) {
    def request = [
      chat_id: chat_id,
      text: message,
      important: important
    ]
    httpRequest url: botUrl, requestBody: new JsonBuilder(request).toString(), httpMode: 'POST', customHeaders: [
            [name: 'content-type', value: 'application/json'],
            [name: 'Authorization', value: "OAuth ${YANDEX_BOT_TOKEN}"]
    ]
  }
}