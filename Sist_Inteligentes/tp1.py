# T2.1. Desenvolva uma função em Python capaz de indicar se um dado valor numérico inteiro trata-se de um valor par ou ímpar.

def par_impar(num):
    if num%2 == 0:
        return('Par')
    else:
        return('Ímpar')

# T2.2. Desenvolva uma função em Python capaz de calcular a média dado uma lista de valores numéricos inteiros.

def media(lista):
    soma = 0
    i = 0
    for i in range(i,len(lista)):
        soma = soma + lista[i]
    print(soma/len(lista))
    return soma/len(lista)

"""T2.3. Desenvolva em Python a classe Person. Dentro desta classe, considere o desenvolvimento da função “__init__” responsável por inicializar instâncias da
classe Person, contendo informações relativamente ao primeiro e último nome,idade e nacionalidade da pessoa. Adicionalmente, desenvolva a função
“printfname” responsável por imprimir o primeiro nome da pessoa, dado uma instância da classe Person."""

import tp1_classes as cla

Maria = cla.Person('Maria','Eduarda',25,'portuguesa')

Maria.printfname()

"""T2.4. Desenvolva em Python a classe Student que irá herdar as propriedades e métodos da classe Person, desenvolvido na T2.3. Adicionalmente, a classe Student
deverá conter informação relativamente ao seu curso e ano acadêmico."""

"""T2.5. Dado o dictionary ‘phone_book’, desenvolva uma função que verifique a existência de uma chave no respetivo dictionary, e caso este exista, imprima o par
chave e respetivo valor armazenado.
"""
phone_book = {"John" : [ "8592970000", "" ],"Bob" : [ "7994880000", "" ],"Tom" : [ "9749552647", "" ]}

def is_there_key(dic,chave):
    if chave in dic.keys():
        res = (f'A chave {chave} tem o valor')
        for elem in dic[chave]:
            res = res + ' ' + elem 
        print(res)
    else:
        print('A chave não está no dicionário')

is_there_key(phone_book,'Bob')