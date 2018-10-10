#We define formats for header and content. So we can reuse content format.
header_format = "{:^20s} {:6s} {:10s}   {:^12s} {:10s}"
content_format = "{:^20d} {:<6d} {:12,.2f}   {:10,.2f} {:12,.2f}   {:s}"

#We define a separator to use at several points while printing
separator = '-' * 90

#This function is the main entry point of our program
def main(grossProfit, expenses, year):
	netProfit = grossProfit - expenses
	yearFirstNetProfit = 0
	mark = ''
	
	print(separator)
	print(header_format.format("Years in operation", "Year", "Gross Profit", "Expenses", "Net Profit"))
	print(separator)
	
	for i in range(20):
		#We define if this is the first year in which we actually receive Net Profit
		if(netProfit > 0 and yearFirstNetProfit == 0):
			yearFirstNetProfit = year
			mark = '* Year first Net Profit'

		print(content_format.format(i, year, grossProfit, expenses, netProfit, mark))
		
		#Update variables for next iteration
		year+=1
		grossProfit *= 1.10
		expenses *= 1.04
		netProfit = grossProfit - expenses
		mark = ''
	
	print(separator)
	print("First true Net Profit will be at: {:d}".format(yearFirstNetProfit))
	print(separator)
	
#We invoke our main function by passing grossProfit, expenses and initial year
main(20000, 35000, 2018)