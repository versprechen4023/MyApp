import pyautogui as pmc
import keyboard as key

pressed = False
path = "C:\\Users\\Administrator\\Desktop\\pyTest\\nyanCat.jpg"
print("파일 실행")
while True:
    input = key.is_pressed('F12')

    if input and not pressed:
        x, y = pmc.position()
        print(x, y)
        myNyan = pmc.locateAllOnScreen(path, confidence = 0.8)
        for my in myNyan :
            print(my)
            
        pressed = True
    elif not input:
        pressed = False

    if key.is_pressed('ctrl') and key.is_pressed('F11'):
        break