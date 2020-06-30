## Class Exercise

An exercise on classes, and dependencies, at a company's salary system. E.g. `Employee` class originated form a `Person` class, `Manager` class originated form a `Employee` class. Each classs has its own properties and functions. Fun, huh? Code below:

```
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
        print("Hi my name is \(name) and I'm doing work. I make \(salary+1000) dollars")
        salary+=1
    }
    
}

// ----Create dependent class-----
class Manager: Employee {
    var teamSize = 0
    
    init(Manager name:String) {
        super.init(employee: name)
        self.role = "manager"
        salary += 500
    }
    override func doWork() {
        super.doWork()
        print("I'm managing people")
        salary += 500
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
print(myManager.role)


let myEmployee = Employee(employee:"Jan")

myEmployee.doWork()

let myEmployee2 = Employee(employee: "Zosia")
print("My name is ", myEmployee2.name, ". I'am a ", myEmployee2.role)


```