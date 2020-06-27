import UIKit

class Pets {
    var name:String = ""
    
    init() {
        name = "Pet init 1"
    }
    
    init(_ name:String) {
        self.name = name
        
    }
    
    // functions
    
    func feed() {
        print("\(name) has been fed")
    }
    func clean() {
        print("\(name) has taken a bath")
    }
    func play() {
        print("\(name) enjoyed playing with you")
    }
    func sleep() {
        print("\(name) went to sleep")
        }
    
    
}

class Tamagotchi: Pets {
    
    var properties:[Int] = [0, 0, 0, 0]
    var ageInDays:Double
    var age:Double? {
        return ageInDays/30
    }
    var timesSlept:Double = 0
    
    
    
    
    override init() {
        self.ageInDays = 0
        super.init()
        properties[2] = 60 // boredom
        
    }
    convenience override init(_ name:String) {
        self.init()
        self.name = name
    }
    
    
    // override functions
     
     override func feed() {
        if properties[0] == 0 {
            print("\(name) is already full")
        }
        else {
            super.feed()
            properties[0] = 7
            properties[2] += 20
            properties[1] += 20
            properties[3] += 10
        }
     }
     override func clean() {
        if properties[1] == 0 {
            print("\(name) is already clean")
        }
        else {
            super.clean()
            properties[0] = 7
            properties[2] += 20
            properties[1] += 20
            properties[3] += 10
        }
     }
     override func play() {
         
        if properties[2] == 0 {
             print("\(name) is already done playing")
         }
         else {
             super.play()
            properties[0] = 7
            properties[2] += 20
            properties[1] += 20
            properties[3] += 10
         }
    }
     override func sleep() {
        
         
        if properties[3] == 0 {
            print("\(name) has already slept")
            print ("\(timesSlept) times")
        }
        else {
            super.sleep()
            properties[0] = 7
            properties[2] += 20
            properties[1] += 20
            properties[3] += 10
            ageInDays += 1
        }
         }
     func check() {
     print("hunger \(properties[0])")
     if properties[0] >= 60 {
         print("\(name) is hungry")
     }
     print("dirt \(properties[1])")
     if properties[1] >= 60 {
         print("\(name) is dirty")
     }
     print("boredom \(properties[2])")
     if properties[2] >= 60 {
         print("\(name) is bored")
     }
     print("drowsiness \(properties[2])")
     if properties[3] >= 60 {
         print("\(name) is sleepy")
     }
     }
     func getAge() {
        print("\(name) is \(age!)  months old")
    
     }
}

let myTama:Tamagotchi = Tamagotchi("konrado")
myTama.play()
myTama.sleep()
myTama.check()
myTama.getAge()



