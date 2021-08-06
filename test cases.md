# story 1
[] Case1  
    Given a parking lot, and a car  
    When park the car  
    Then return a parking ticket. 

[] Case2  
    Given a correct ticket  
    When fetch the car 
    Then return car  

[] Case3  
    Given a wrong ticket  
    When fetch the car   
    Then return no car

[] Case4  
    Given a ticket that has already been used  
    When fetch the car  
    Then return no car

[] Case5  
    Given a parking lot with no space, and a car  
    When park the car
    Then return no parking ticket. 
