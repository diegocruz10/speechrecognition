import speech_recognition as sr

print("***********************************")
print("*Bienvenido, Seleccione una opcion*")
print("***********************************")
print("")	
print("1. One")
print("2. Two")
print("3. Three")
print("4. Four")

r = sr.Recognizer()
with sr.Microphone() as source:
	print("...")
	audio = r.listen(source)

text = r.recognize_google(audio)	
	
if(text == "One" or text == "1"):
	print("Option 1 selected")	
elif(text == "Two" or text == "2"):
	print("Option 2 selected")
elif(text == "Three" or text == "3"):
	print("Option 3 selected")
elif(text == "Four" or text == "4"):
	print("Option 4 selected")
	