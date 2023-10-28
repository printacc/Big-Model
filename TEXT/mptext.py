from gtts import gTTS
import os
from playsound import playsound
import os


os.environ['http_proxy'] = '127.0.0.1:7890'
os.environ['https_proxy'] = '127.0.0.1:7890'



while True:
    input_text = input("请输入要转换的文本（按 q 键退出）：")
    if input_text.lower() == "q":
        break

    language = 'en'
    output = gTTS(text=input_text, lang=language, slow=False)
    output.save("output.mp3")
    
    playsound("output.mp3")

    os.remove("output.mp3")