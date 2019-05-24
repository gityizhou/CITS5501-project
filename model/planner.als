// Your alloy model should go in here
open util/ordering[TravelStop] as ts

sig TravelStop{nextTravelStop: lone TravelStop}

sig Route{travelStop: some TravelStop}

sig Time{}

fact NextStop_notself{
	all n : TravelStop | n.nextTravelStop != n
	}

fact TravelStopModel{
	all n : TravelStop - last | one n.nextTravelStop && n.nextTravelStop = n.next
	no last.nextTravelStop
	#TravelStop >= 1
}

//Include an assertion that a route from starting stop A to ending stop B has exactly the same number of items in it as the reverse trip.


assert checkReverse{ #first.nexts = #last.prevs
}
check checkReverse for 5
//Include an assertion that a route from any stop to itself consists of only one stop.

assert oneStopCheck{
	first = last
}
check oneStopCheck for 5 but 1 Route