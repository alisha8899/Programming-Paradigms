class Truck:
    def getAxles(self):
        pass

    def getWeight(self):
        pass


class TollBooth:
    def displayData(self):
        pass

    def calculate(self, T: Truck):
        pass


class FordTruck(Truck):

    def __init__(self, axles: int, weight: int):
        self.axles = axles
        self.weight = weight

    def getAxles(self):
        return self.axles

    def getWeight(self):
        return self.weight


class NissanTruck(FordTruck):
    pass


class Toll(TollBooth):

    def __init__(self):
        self.numberofTrucks = 0
        self.receipts = 0

    def calculate(self, x: Truck):
        axles = x.getAxles()
        Weight = x.getWeight()

        tollDue = 5 * axles + 10 * (Weight / 1000)

        print("Truck arrival - Axles: ", axles, "axles")
        print("Total Weight : ", Weight, "kg")

        self.numberofTrucks += 1

        self.receipts += tollDue

        print("Amount due For truck", self.numberofTrucks, ":", tollDue)

    def displayData(self):
        print("Trucks:", self.numberofTrucks)

        print("Totals since last collection - Receipts: ", self.receipts)

    def collect(self):
        print("*** Collecting receipts  ***")
        self.displayData()
        self.numberofTrucks = 0;
        self.receipts = 0;


def main():
    booth = Toll()
    Ford = FordTruck(5, 12500)
    Nissan = NissanTruck(2, 5000)


    booth.calculate(Ford);
    booth.calculate(Nissan);
    booth.collect();

    booth.calculate(Ford);
    booth.calculate(Nissan);
    booth.displayData();

    booth.calculate(Ford);
    booth.calculate(Nissan);
    booth.collect();

# calling main()
main()