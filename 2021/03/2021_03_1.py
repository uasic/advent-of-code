file = open('input.txt', 'r') 

# seznam z vsotami posameznega stolpca

stevci = [0] * 12
print(stevci)

stevilo_vrstic = 0
for line in file:
    line = line.strip()
    for i, znak in enumerate(line):
        stevci[i] += int(znak)
    stevilo_vrstic += 1

print('stevci: ', stevci)
print('stevilo vrstic: ', stevilo_vrstic)


gama_rate_binarno = [0] * 12
epsilon_rate_binarno = [0] * 12

for i, stevec in enumerate(stevci):
    if (stevec > stevilo_vrstic / 2):
        gama_rate_binarno[i] = 1
        epsilon_rate_binarno[i] = 0
    else:
        gama_rate_binarno[i] = 0
        epsilon_rate_binarno[i] = 1

print('gama rate binarno:', gama_rate_binarno)
print('elsilon rate binarno: ', epsilon_rate_binarno)


for i in gama_rate_binarno:
    print(i,end="")
    #000011011001

for i in epsilon_rate_binarno:
    print(i,end="")
    #111100100110


Gama = 217
Epsilon = 3878

Rezultat = Gama * Epsilon
print('Rezultat:', Rezultat)

