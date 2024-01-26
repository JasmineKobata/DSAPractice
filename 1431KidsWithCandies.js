var kidsWithCandies = function(candies, extraCandies) {
    var maxCandies = Math.max(...candies);
    var results = [];

    for (let i=0; i < candies.length; i++) {
        results.push(candies[i] + extraCandies >= maxCandies ? true : false);
    }
    return results;
};