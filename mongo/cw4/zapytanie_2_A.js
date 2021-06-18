var balance = {$toDouble: "$credit.balance"}
db.people.aggregate([
    {$unwind: {path: "$credit"}},
    {$group: {
        _id: "$credit.currency",
        total_balance: {"$sum": balance}}}
])
