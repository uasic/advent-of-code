# Nalaganje txt datoteke

#f = open('C:/Users/urska/Documents/GitHub/advent-of-code/2021/02/input.txt', 'r')
f = open('input.txt', 'r') 

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

#print(list2)

a = 0
b = 3
vsote_seznam = []

while b <= 2000:
  vsota = sum(list2[a:b])
  vsote_seznam.append(vsota)
  a = a + 1
  b = b + 1

print(vsote_seznam)

stevec = 0
for idx in range(1, len(vsote_seznam)):
    #print(len(vsote_seznam))
    if vsote_seznam[idx - 1] < vsote_seznam[idx]:
        stevec = stevec + 1
    
print(stevec)




f.close()



