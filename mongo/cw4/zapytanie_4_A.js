var weight = {$toDouble: "$weight"}
var height = {$toDouble: "$height"}
var bmi = {
    $divide: [weight, {$pow: [{$divide: [height, 100]}, 2]}]
}
db.people.aggregate([
    {$group: {
        _id: "$nationality",
        bmi: {"$avg": bmi}}}
])

