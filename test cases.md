# Story 1
[x] Case1  
    Given a parking lot, and a car  
    When park the car  
    Then return a parking ticket. 

[x] Case2  
    Given a parking lot, a parked car, and correct ticket  
    When fetch the car 
    Then return car  

[x] Case3  
    Given a parking lot, two parked cars, and two parking tickets 
    When fetch twice  
    Then return the right car

[x] Case4  
    Given a wrong ticket  
    When fetch the car   
    Then return no car

[x] Case5  
    Given a ticket that has already been used  
    When fetch the car  
    Then return no car

[x] Case6  
    Given a parking lot with no space, and a car  
    When park the car
    Then return no parking ticket. 

# Story 2
[x] Case1  
    Given a parking lot, and unrecognized ticket  
    When fetch the car  
    Then return nothing with error message "Unrecognized parking ticket."  

[x] Case2  
    Given a parking lot, and a used ticket  
    When fetch the car  
    Then return nothing with error message "Unrecognized parking ticket."  

[x] Case3  
    Given a parking lot without any position, and a car  
    When park the car  
    Then return nothing with error message "No available position."  

# Story 3
[x] Case1  
    Given a parking lot, and a car  
    When park the car by standard parking boy  
    Then return a parking ticket.  

[x] Case2  
    Given a parking lot, a parked car, and a correct ticket  
    When fetch the car by standard parking boy  
    Then return car  

[x] Case3  
    Given a parking lot, two parked cars, and two parking tickets  
    When fetch twice by standard parking boy  
    Then return the right car

[x] Case4  
    Given a parking lot, and unrecognized ticket  
    When fetch the car by standard parking boy  
    Then return nothing with error message "Unrecognized parking ticket."

[x] Case5  
    Given a parking lot, and a used ticket  
    When fetch the car by standard parking boy  
    Then return nothing with error message "Unrecognized parking ticket."

[x] Case6  
    Given a parking lot without any position, and a car  
    When park the car by standard parking boy  
    Then return nothing with error message "No available position." 
