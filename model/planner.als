// Your alloy model should go in here
open util/ordering[TravelStop] as ts

// set up tavelstop sig which have 0 or 1 nextravelstop and have a stop time for each travelstop
sig TravelStop{nextTravelStop: lone TravelStop, stopTime: one Time}

//set up Route sig which have one or more travelstops
sig Route{travelStop: some TravelStop}

//set up a time which is used to show the stoptime for every travelstop
sig Time{}

//make the fact that the next stop of this travelstop is not itself
fact NextStop_notself{
	all n : TravelStop | n.nextTravelStop != n
	}

//set up the stop model of the travel stops
fact TravelStopModel{
	all n : TravelStop - last | one n.nextTravelStop && n.nextTravelStop = n.next
	no last.nextTravelStop
	#TravelStop >= 1
}

//assert a route from starting stop A to ending stop B has exactly the same number of items in it as the reverse trip.
assert checkReverse{ #first.nexts = #last.prevs
}
check checkReverse for 5


//Include an assertion that a route from any stop to itself consists of only one stop.
assert oneStopCheck{
	first = last
}
check oneStopCheck for 5 but 1 TravelStop