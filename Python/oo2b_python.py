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

    def collect(self):
        pass

    def listOfTrucks(self):
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
        self.list = []

    def calculate(self, x: FordTruck):
        self.list.append(x)
        axles = x.getAxles()
        Weight = x.getWeight()

        tollDue = 5 * axles + 10 * (Weight / 1000)

        print("Truck arrival - Axles:", axles, "axles")
        print("Total Weight: ", Weight, "kg")

        self.numberofTrucks += 1
        print("Amount due For truck", self.numberofTrucks, ":", tollDue)

    def listOfTrucks(self):
        print("List of Trucks :", self.numberofTrucks)
        for i in range(self.numberofTrucks):
            print("Truck': ", i + 1, ":")
            a = self.list[i]
            axles = a.getAxles()
            Weight = a.getWeight()
            tollDue = 5 * axles + 10 * (Weight / 1000)
            print("Axles:", axles)
            print("Truck weight: ", Weight, "kg")

    def displayData(self):
        print("Trucks: ", self.numberofTrucks)
        total = 0
        for i in range(self.numberofTrucks):
            a = self.list[i]
            axles = a.getAxles()
            Weight = a.getWeight()
            tollDue = 5 * axles + 10 * (Weight / 1000)
            total += tollDue
        print("Total amount of Receipts when", self.numberofTrucks, "Truck Passes The Toll :", total)

    def collect(self):
        print("Cleaning out Collection")
        self.displayData()
        self.numberofTrucks = 0;


def main():
    booth = Toll()
    ford = FordTruck(5, 12500)
    nissan = NissanTruck(2, 5000)

    booth.calculate(ford);
    booth.calculate(nissan);

    booth.calculate(ford);
    booth.calculate(nissan);

    booth.displayData();

    booth.calculate(ford);
    booth.calculate(nissan);

    booth.displayData();

main()