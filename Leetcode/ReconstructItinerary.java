// Given a list of airline tickets represented by pairs of 
// departure and arrival airports [from, to], 
// reconstruct the itinerary in order. 
// All of the tickets belong to a man who departs from JFK. 
// Thus, the itinerary must begin with JFK.

// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.

// Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		Map<String, String> cities = new HashMap<String, String>();
		List<String> itinerary = new ArrayList<String>();
		itinerary.add("JFK");

        for (int i = 0; i < tickets.length; i++) {
        	String[] ticket = tickets[i];
        	String org = ticket[0];
        	String dest = ticket[1];
        	cities.add(org, dest);
        }

        String org = "JFK";
        String dest;
        while ((dest = cities.get(org)) != null) {
        	itinerary.add(dest);
        }
        return itinerary;
    }
}