class Person():
    def __init__(self,firstName,lastName,age,nac):
        self.firstName = firstName
        self.lastName = lastName
        self.age = age
        self.nac = nac


    def printfname(self):
        print(self.firstName)

class Student(Person):

    def __init__(self,course,year,firstName,lastName,age,nac):
        super().__init__(self,firstName,lastName,age,nac)
        self.course = course
        self.year = year
