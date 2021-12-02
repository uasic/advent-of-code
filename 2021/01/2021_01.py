# Nalaganje txt datoteke

#f = open('C:/Users/urska/Documents/GitHub/advent-of-code/2021/01/input.txt', 'r')
f = open('input.txt', 'r') 

# prešteješ, da ima 2000 vrstic

# primerjaj vrstico n in n + 1, če je n + 1 večja, števcu prištej 1

list = []
for line in f:
  stripped_line = line.strip()
  line_list = stripped_line.split()
  list.append(line_list)

#print(list)

flat_list = []
for sublist in list:
    for item in sublist:
        flat_list.append(item)
#print(flat_list)


list2 = []

for i in flat_list:
  list2.append(int(i))

f.close()

#print(list2)

stevec = 0
for idx in range(1, len(list2)):
    if list2[idx - 1] < list2[idx]:
        stevec = stevec + 1
    
print(stevec)





