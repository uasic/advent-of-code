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



file = open('input.txt', 'r') 
izlocitveni_seznam = []

for line in file:
  stripped_line = line.strip()
  vrstica_za_seznam = stripped_line.split()
  izlocitveni_seznam.append(vrstica_za_seznam)
#print(izlocitveni_seznam)

# to zdej vrže seznam vseh vrstic

# zdej pa moreš spet seštet vse številke v vsakem stolpcu, vmes preden nadaljuješ na naslednji stolpec pa izloči neustrezne vrstice iz izlocitvenega seznama
# kisik: obdržiš pogostejšo številko, če je število 0 in 1 enako, potem obdržiš vrstice, ki se začnejo z 1
# co2: obdržiš redkejšo številko, če je zastopanost enaka, obdržiš 0

# najprej za kisik:

file = open('input.txt', 'r') 
#stevci = [0] * 12
#print(stevci)

stevilo_vrstic = 0
vsota_stolpca = 0

for line in file:
    line = line.strip()

    for i in line:
        print('prva stevilka: ' , i)


    ''''
    for i, znak in enumerate(line):
        stevci[i] += int(znak)
    stevilo_vrstic += 1
    '''

print('stevci: ', stevci)
print('stevilo vrstic: ', stevilo_vrstic)



kisik = []
ogljikov_dioksid = []

# kisik, obdržiš tiste s pogostejšimi številkami, če je enko in 0 enako, obdržiš 1


'''
o=1726
co=1726

Rezultat = o*co
print(Rezultat)
'''
