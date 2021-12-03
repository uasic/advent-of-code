#file = open ("C:/Users/urska/Documents/GitHub/advent-of-code/2021/02/input.txt", "r")
#print(file.read())

file = open ("C:/Users/urska/Documents/GitHub/advent-of-code/2021/02/input.txt", "r")

globina = 0
horizontal = 0
aim = 0

for line in file:
    key, value = line.split()

    #print(key)
    value = int(value)
    #type(value)
    #print(type(value))
    
    #print(type(horizontal))
    #print(type(value))
    #print(type(aim)) 

    if key == "down":
        aim = aim + value
        #print(aim)

    elif key == "up":
        aim = aim - value
        #print(aim)
       
    elif key == "forward":
        horizontal = horizontal + value
        globina = globina + aim * value   
'''
print("horizontal")
print(horizontal)
print("globina")
print(globina) 
'''

rezultat = horizontal * globina
print("rezultat")
print(rezultat)

file.close