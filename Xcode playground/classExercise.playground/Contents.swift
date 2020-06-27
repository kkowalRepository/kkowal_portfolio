import UIKit

// ----Create class-----
class Person {
    var name = ""
    init(person name:String) {
        self.name = name
    }
}
// ----Create dependent class-----
class Employee: Person {
    
    var salary = 0
    var role = ""
    
    init(employee name:String) {
        super.init(person: name)
        self.role = "Software tester"
    }
    
    func doWork() {
        print("Hi my name is \(name) and I'm doing work. I make \(salary+1) dollars")
        salary+=1
    }
    
}

// ----Create dependent class-----
class Manager: Employee {
    var teamSize = 0
    
    init(Manager name:String) {
        super.init(employee: name)
        self.role = "manager"
        salary += 2
    }
    override func doWork() {
        super.doWork()
        print("I'm managing people")
        salary += 2
    }
    func firePeople() {
        print("I'm firing people")
    }
}
let myPerson = Person(person: "Konrad")
print(myPerson.name)

let myManager = Manager(Manager: "Joanna")
print(myManager.name)
print(myManager.salary)


let myEmployee = Employee(employee:"Jan")

myEmployee.doWork()

let myEmployee2 = Employee(employee: "Zosia")
print(myEmployee2.name)
print(myEmployee2.role)

