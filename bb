{
 "cells": [
  {
   "cell_type": "markdown",
   "id": "c6269683",
   "metadata": {},
   "source": [
    "# Global Sales Data Analytics"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "5209ddf6",
   "metadata": {},
   "source": [
    "<h4> IMPORTING REQUIRED LIBRARIES\n",
    "  "
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 2,
   "id": "0b03c99b",
   "metadata": {},
   "outputs": [],
   "source": [
    "#Data Manipulation\n",
    "import pandas as pd\n",
    "#Data Visualization \n",
    "import matplotlib.pyplot as plt\n",
    "%matplotlib inline\n",
    "import seaborn as sns\n",
    "import numpy as np"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "83b5347c",
   "metadata": {},
   "source": [
    "#### IMPORTING THE DATASET"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 3,
   "id": "96bd42b9",
   "metadata": {},
   "outputs": [],
   "source": [
    "df = pd.read_excel('Global_Superstore.xlsx')"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 4,
   "id": "c2ce2bd6",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/html": [
       "<div>\n",
       "<style scoped>\n",
       "    .dataframe tbody tr th:only-of-type {\n",
       "        vertical-align: middle;\n",
       "    }\n",
       "\n",
       "    .dataframe tbody tr th {\n",
       "        vertical-align: top;\n",
       "    }\n",
       "\n",
       "    .dataframe thead th {\n",
       "        text-align: right;\n",
       "    }\n",
       "</style>\n",
       "<table border=\"1\" class=\"dataframe\">\n",
       "  <thead>\n",
       "    <tr style=\"text-align: right;\">\n",
       "      <th></th>\n",
       "      <th>Row ID</th>\n",
       "      <th>Order ID</th>\n",
       "      <th>Order Date</th>\n",
       "      <th>Ship Date</th>\n",
       "      <th>Ship Mode</th>\n",
       "      <th>Customer ID</th>\n",
       "      <th>Customer Name</th>\n",
       "      <th>Segment</th>\n",
       "      <th>City</th>\n",
       "      <th>State</th>\n",
       "      <th>...</th>\n",
       "      <th>Product ID</th>\n",
       "      <th>Category</th>\n",
       "      <th>Sub-Category</th>\n",
       "      <th>Product Name</th>\n",
       "      <th>Sales</th>\n",
       "      <th>Quantity</th>\n",
       "      <th>Discount</th>\n",
       "      <th>Profit</th>\n",
       "      <th>Shipping Cost</th>\n",
       "      <th>Order Priority</th>\n",
       "    </tr>\n",
       "  </thead>\n",
       "  <tbody>\n",
       "    <tr>\n",
       "      <th>0</th>\n",
       "      <td>32298</td>\n",
       "      <td>CA-2012-124891</td>\n",
       "      <td>31-07-2012</td>\n",
       "      <td>31-07-2012</td>\n",
       "      <td>Same Day</td>\n",
       "      <td>RH-19495</td>\n",
       "      <td>Rick Hansen</td>\n",
       "      <td>Consumer</td>\n",
       "      <td>New York City</td>\n",
       "      <td>New York</td>\n",
       "      <td>...</td>\n",
       "      <td>TEC-AC-10003033</td>\n",
       "      <td>Technology</td>\n",
       "      <td>Accessories</td>\n",
       "      <td>Plantronics CS510 - Over-the-Head monaural Wir...</td>\n",
       "      <td>2309.650</td>\n",
       "      <td>7</td>\n",
       "      <td>0.0</td>\n",
       "      <td>762.1845</td>\n",
       "      <td>933.57</td>\n",
       "      <td>Critical</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>1</th>\n",
       "      <td>26341</td>\n",
       "      <td>IN-2013-77878</td>\n",
       "      <td>05-02-2013</td>\n",
       "      <td>07-02-2013</td>\n",
       "      <td>Second Class</td>\n",
       "      <td>JR-16210</td>\n",
       "      <td>Justin Ritter</td>\n",
       "      <td>Corporate</td>\n",
       "      <td>Wollongong</td>\n",
       "      <td>New South Wales</td>\n",
       "      <td>...</td>\n",
       "      <td>FUR-CH-10003950</td>\n",
       "      <td>Furniture</td>\n",
       "      <td>Chairs</td>\n",
       "      <td>Novimex Executive Leather Armchair, Black</td>\n",
       "      <td>3709.395</td>\n",
       "      <td>9</td>\n",
       "      <td>0.1</td>\n",
       "      <td>-288.7650</td>\n",
       "      <td>923.63</td>\n",
       "      <td>Critical</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>2</th>\n",
       "      <td>25330</td>\n",
       "      <td>IN-2013-71249</td>\n",
       "      <td>17-10-2013</td>\n",
       "      <td>18-10-2013</td>\n",
       "      <td>First Class</td>\n",
       "      <td>CR-12730</td>\n",
       "      <td>Craig Reiter</td>\n",
       "      <td>Consumer</td>\n",
       "      <td>Brisbane</td>\n",
       "      <td>Queensland</td>\n",
       "      <td>...</td>\n",
       "      <td>TEC-PH-10004664</td>\n",
       "      <td>Technology</td>\n",
       "      <td>Phones</td>\n",
       "      <td>Nokia Smart Phone, with Caller ID</td>\n",
       "      <td>5175.171</td>\n",
       "      <td>9</td>\n",
       "      <td>0.1</td>\n",
       "      <td>919.9710</td>\n",
       "      <td>915.49</td>\n",
       "      <td>Medium</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>3</th>\n",
       "      <td>13524</td>\n",
       "      <td>ES-2013-1579342</td>\n",
       "      <td>28-01-2013</td>\n",
       "      <td>30-01-2013</td>\n",
       "      <td>First Class</td>\n",
       "      <td>KM-16375</td>\n",
       "      <td>Katherine Murray</td>\n",
       "      <td>Home Office</td>\n",
       "      <td>Berlin</td>\n",
       "      <td>Berlin</td>\n",
       "      <td>...</td>\n",
       "      <td>TEC-PH-10004583</td>\n",
       "      <td>Technology</td>\n",
       "      <td>Phones</td>\n",
       "      <td>Motorola Smart Phone, Cordless</td>\n",
       "      <td>2892.510</td>\n",
       "      <td>5</td>\n",
       "      <td>0.1</td>\n",
       "      <td>-96.5400</td>\n",
       "      <td>910.16</td>\n",
       "      <td>Medium</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>4</th>\n",
       "      <td>47221</td>\n",
       "      <td>SG-2013-4320</td>\n",
       "      <td>05-11-2013</td>\n",
       "      <td>06-11-2013</td>\n",
       "      <td>Same Day</td>\n",
       "      <td>RH-9495</td>\n",
       "      <td>Rick Hansen</td>\n",
       "      <td>Consumer</td>\n",
       "      <td>Dakar</td>\n",
       "      <td>Dakar</td>\n",
       "      <td>...</td>\n",
       "      <td>TEC-SHA-10000501</td>\n",
       "      <td>Technology</td>\n",
       "      <td>Copiers</td>\n",
       "      <td>Sharp Wireless Fax, High-Speed</td>\n",
       "      <td>2832.960</td>\n",
       "      <td>8</td>\n",
       "      <td>0.0</td>\n",
       "      <td>311.5200</td>\n",
       "      <td>903.04</td>\n",
       "      <td>Critical</td>\n",
       "    </tr>\n",
       "  </tbody>\n",
       "</table>\n",
       "<p>5 rows × 23 columns</p>\n",
       "</div>"
      ],
      "text/plain": [
       "   Row ID         Order ID  Order Date   Ship Date     Ship Mode Customer ID  \\\n",
       "0   32298   CA-2012-124891  31-07-2012  31-07-2012      Same Day    RH-19495   \n",
       "1   26341    IN-2013-77878  05-02-2013  07-02-2013  Second Class    JR-16210   \n",
       "2   25330    IN-2013-71249  17-10-2013  18-10-2013   First Class    CR-12730   \n",
       "3   13524  ES-2013-1579342  28-01-2013  30-01-2013   First Class    KM-16375   \n",
       "4   47221     SG-2013-4320  05-11-2013  06-11-2013      Same Day     RH-9495   \n",
       "\n",
       "      Customer Name      Segment           City            State  ...  \\\n",
       "0       Rick Hansen     Consumer  New York City         New York  ...   \n",
       "1     Justin Ritter    Corporate     Wollongong  New South Wales  ...   \n",
       "2      Craig Reiter     Consumer       Brisbane       Queensland  ...   \n",
       "3  Katherine Murray  Home Office         Berlin           Berlin  ...   \n",
       "4       Rick Hansen     Consumer          Dakar            Dakar  ...   \n",
       "\n",
       "         Product ID    Category Sub-Category  \\\n",
       "0   TEC-AC-10003033  Technology  Accessories   \n",
       "1   FUR-CH-10003950   Furniture       Chairs   \n",
       "2   TEC-PH-10004664  Technology       Phones   \n",
       "3   TEC-PH-10004583  Technology       Phones   \n",
       "4  TEC-SHA-10000501  Technology      Copiers   \n",
       "\n",
       "                                        Product Name     Sales Quantity  \\\n",
       "0  Plantronics CS510 - Over-the-Head monaural Wir...  2309.650        7   \n",
       "1          Novimex Executive Leather Armchair, Black  3709.395        9   \n",
       "2                  Nokia Smart Phone, with Caller ID  5175.171        9   \n",
       "3                     Motorola Smart Phone, Cordless  2892.510        5   \n",
       "4                     Sharp Wireless Fax, High-Speed  2832.960        8   \n",
       "\n",
       "  Discount    Profit  Shipping Cost  Order Priority  \n",
       "0      0.0  762.1845         933.57        Critical  \n",
       "1      0.1 -288.7650         923.63        Critical  \n",
       "2      0.1  919.9710         915.49          Medium  \n",
       "3      0.1  -96.5400         910.16          Medium  \n",
       "4      0.0  311.5200         903.04        Critical  \n",
       "\n",
       "[5 rows x 23 columns]"
      ]
     },
     "execution_count": 4,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df.head()"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "677e84e0",
   "metadata": {},
   "source": [
    "#### CUSTOMER ANALYSIS"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "c9a7b9f9",
   "metadata": {},
   "source": [
    "Profile the customers based on their frequency of purchase - calculate frequency of purchase for each customer and plot a histogram to get the threshold for Low/Mid/High frequency customers\n",
    "\n",
    "Does the high frequent customers are contributing more revenue\n",
    "\n",
    "Are they also profitable - what is the profit margin across the buckets\n",
    "\n",
    "Which customer segment is most profitable in each year ( there is a column called customer segment)\n",
    "\n",
    "How the customers are distributed across the countries - pie chart\n",
    "\n",
    "Write a function to split the global store data into different unique data frames based on the unique values in country column (Means, we should have one data frame for one country as function output )"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 5,
   "id": "10f708c6",
   "metadata": {},
   "outputs": [
    {
     "name": "stdout",
     "output_type": "stream",
     "text": [
      "<class 'pandas.core.frame.DataFrame'>\n",
      "RangeIndex: 51290 entries, 0 to 51289\n",
      "Data columns (total 23 columns):\n",
      " #   Column          Non-Null Count  Dtype  \n",
      "---  ------          --------------  -----  \n",
      " 0   Row ID          51290 non-null  int64  \n",
      " 1   Order ID        51290 non-null  object \n",
      " 2   Order Date      51290 non-null  object \n",
      " 3   Ship Date       51290 non-null  object \n",
      " 4   Ship Mode       51290 non-null  object \n",
      " 5   Customer ID     51290 non-null  object \n",
      " 6   Customer Name   51290 non-null  object \n",
      " 7   Segment         51290 non-null  object \n",
      " 8   City            51290 non-null  object \n",
      " 9   State           51290 non-null  object \n",
      " 10  Country         51290 non-null  object \n",
      " 11  Market          51290 non-null  object \n",
      " 12  Region          51290 non-null  object \n",
      " 13  Product ID      51290 non-null  object \n",
      " 14  Category        51290 non-null  object \n",
      " 15  Sub-Category    51290 non-null  object \n",
      " 16  Product Name    51290 non-null  object \n",
      " 17  Sales           51290 non-null  float64\n",
      " 18  Quantity        51290 non-null  int64  \n",
      " 19  Discount        51290 non-null  float64\n",
      " 20  Profit          51290 non-null  float64\n",
      " 21  Shipping Cost   51290 non-null  float64\n",
      " 22  Order Priority  51290 non-null  object \n",
      "dtypes: float64(4), int64(2), object(17)\n",
      "memory usage: 9.0+ MB\n"
     ]
    }
   ],
   "source": [
    "df.info()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 6,
   "id": "ffb3ec19",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "(51290, 23)"
      ]
     },
     "execution_count": 6,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df.shape"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 7,
   "id": "9d0bdd3b",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/html": [
       "<div>\n",
       "<style scoped>\n",
       "    .dataframe tbody tr th:only-of-type {\n",
       "        vertical-align: middle;\n",
       "    }\n",
       "\n",
       "    .dataframe tbody tr th {\n",
       "        vertical-align: top;\n",
       "    }\n",
       "\n",
       "    .dataframe thead th {\n",
       "        text-align: right;\n",
       "    }\n",
       "</style>\n",
       "<table border=\"1\" class=\"dataframe\">\n",
       "  <thead>\n",
       "    <tr style=\"text-align: right;\">\n",
       "      <th></th>\n",
       "      <th>Row ID</th>\n",
       "      <th>Sales</th>\n",
       "      <th>Quantity</th>\n",
       "      <th>Discount</th>\n",
       "      <th>Profit</th>\n",
       "      <th>Shipping Cost</th>\n",
       "    </tr>\n",
       "  </thead>\n",
       "  <tbody>\n",
       "    <tr>\n",
       "      <th>count</th>\n",
       "      <td>51290.00000</td>\n",
       "      <td>51290.000000</td>\n",
       "      <td>51290.000000</td>\n",
       "      <td>51290.000000</td>\n",
       "      <td>51290.000000</td>\n",
       "      <td>51290.000000</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>mean</th>\n",
       "      <td>25645.50000</td>\n",
       "      <td>246.490581</td>\n",
       "      <td>3.476545</td>\n",
       "      <td>0.142908</td>\n",
       "      <td>28.610982</td>\n",
       "      <td>26.375915</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>std</th>\n",
       "      <td>14806.29199</td>\n",
       "      <td>487.565361</td>\n",
       "      <td>2.278766</td>\n",
       "      <td>0.212280</td>\n",
       "      <td>174.340972</td>\n",
       "      <td>57.296804</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>min</th>\n",
       "      <td>1.00000</td>\n",
       "      <td>0.444000</td>\n",
       "      <td>1.000000</td>\n",
       "      <td>0.000000</td>\n",
       "      <td>-6599.978000</td>\n",
       "      <td>0.000000</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>25%</th>\n",
       "      <td>12823.25000</td>\n",
       "      <td>30.758625</td>\n",
       "      <td>2.000000</td>\n",
       "      <td>0.000000</td>\n",
       "      <td>0.000000</td>\n",
       "      <td>2.610000</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>50%</th>\n",
       "      <td>25645.50000</td>\n",
       "      <td>85.053000</td>\n",
       "      <td>3.000000</td>\n",
       "      <td>0.000000</td>\n",
       "      <td>9.240000</td>\n",
       "      <td>7.790000</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>75%</th>\n",
       "      <td>38467.75000</td>\n",
       "      <td>251.053200</td>\n",
       "      <td>5.000000</td>\n",
       "      <td>0.200000</td>\n",
       "      <td>36.810000</td>\n",
       "      <td>24.450000</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>max</th>\n",
       "      <td>51290.00000</td>\n",
       "      <td>22638.480000</td>\n",
       "      <td>14.000000</td>\n",
       "      <td>0.850000</td>\n",
       "      <td>8399.976000</td>\n",
       "      <td>933.570000</td>\n",
       "    </tr>\n",
       "  </tbody>\n",
       "</table>\n",
       "</div>"
      ],
      "text/plain": [
       "            Row ID         Sales      Quantity      Discount        Profit  \\\n",
       "count  51290.00000  51290.000000  51290.000000  51290.000000  51290.000000   \n",
       "mean   25645.50000    246.490581      3.476545      0.142908     28.610982   \n",
       "std    14806.29199    487.565361      2.278766      0.212280    174.340972   \n",
       "min        1.00000      0.444000      1.000000      0.000000  -6599.978000   \n",
       "25%    12823.25000     30.758625      2.000000      0.000000      0.000000   \n",
       "50%    25645.50000     85.053000      3.000000      0.000000      9.240000   \n",
       "75%    38467.75000    251.053200      5.000000      0.200000     36.810000   \n",
       "max    51290.00000  22638.480000     14.000000      0.850000   8399.976000   \n",
       "\n",
       "       Shipping Cost  \n",
       "count   51290.000000  \n",
       "mean       26.375915  \n",
       "std        57.296804  \n",
       "min         0.000000  \n",
       "25%         2.610000  \n",
       "50%         7.790000  \n",
       "75%        24.450000  \n",
       "max       933.570000  "
      ]
     },
     "execution_count": 7,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df.describe()\n",
    "# checks the negative trend in profit and the decrease in discount of range"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 8,
   "id": "3b8181d4",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Row ID            0\n",
       "Order ID          0\n",
       "Order Date        0\n",
       "Ship Date         0\n",
       "Ship Mode         0\n",
       "Customer ID       0\n",
       "Customer Name     0\n",
       "Segment           0\n",
       "City              0\n",
       "State             0\n",
       "Country           0\n",
       "Market            0\n",
       "Region            0\n",
       "Product ID        0\n",
       "Category          0\n",
       "Sub-Category      0\n",
       "Product Name      0\n",
       "Sales             0\n",
       "Quantity          0\n",
       "Discount          0\n",
       "Profit            0\n",
       "Shipping Cost     0\n",
       "Order Priority    0\n",
       "dtype: int64"
      ]
     },
     "execution_count": 8,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df.isnull().sum()\n",
    "# checks if there are null entries"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "a4e10014",
   "metadata": {},
   "source": [
    "Checking how many of them are categorical and how many unique values each categorical columns have,"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 9,
   "id": "e58955ed",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Index(['Order ID', 'Order Date', 'Ship Date', 'Ship Mode', 'Customer ID',\n",
       "       'Customer Name', 'Segment', 'City', 'State', 'Country', 'Market',\n",
       "       'Region', 'Product ID', 'Category', 'Sub-Category', 'Product Name',\n",
       "       'Order Priority'],\n",
       "      dtype='object')"
      ]
     },
     "execution_count": 9,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "cat_cols = df.select_dtypes(exclude= ['int64', 'float64']).columns\n",
    "cat_cols"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 10,
   "id": "629b5013",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/html": [
       "<div>\n",
       "<style scoped>\n",
       "    .dataframe tbody tr th:only-of-type {\n",
       "        vertical-align: middle;\n",
       "    }\n",
       "\n",
       "    .dataframe tbody tr th {\n",
       "        vertical-align: top;\n",
       "    }\n",
       "\n",
       "    .dataframe thead th {\n",
       "        text-align: right;\n",
       "    }\n",
       "</style>\n",
       "<table border=\"1\" class=\"dataframe\">\n",
       "  <thead>\n",
       "    <tr style=\"text-align: right;\">\n",
       "      <th></th>\n",
       "      <th>Row ID</th>\n",
       "      <th>Sales</th>\n",
       "      <th>Quantity</th>\n",
       "      <th>Discount</th>\n",
       "      <th>Profit</th>\n",
       "      <th>Shipping Cost</th>\n",
       "    </tr>\n",
       "  </thead>\n",
       "  <tbody>\n",
       "    <tr>\n",
       "      <th>0</th>\n",
       "      <td>32298</td>\n",
       "      <td>2309.650</td>\n",
       "      <td>7</td>\n",
       "      <td>0.0</td>\n",
       "      <td>762.1845</td>\n",
       "      <td>933.57</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>1</th>\n",
       "      <td>26341</td>\n",
       "      <td>3709.395</td>\n",
       "      <td>9</td>\n",
       "      <td>0.1</td>\n",
       "      <td>-288.7650</td>\n",
       "      <td>923.63</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>2</th>\n",
       "      <td>25330</td>\n",
       "      <td>5175.171</td>\n",
       "      <td>9</td>\n",
       "      <td>0.1</td>\n",
       "      <td>919.9710</td>\n",
       "      <td>915.49</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>3</th>\n",
       "      <td>13524</td>\n",
       "      <td>2892.510</td>\n",
       "      <td>5</td>\n",
       "      <td>0.1</td>\n",
       "      <td>-96.5400</td>\n",
       "      <td>910.16</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>4</th>\n",
       "      <td>47221</td>\n",
       "      <td>2832.960</td>\n",
       "      <td>8</td>\n",
       "      <td>0.0</td>\n",
       "      <td>311.5200</td>\n",
       "      <td>903.04</td>\n",
       "    </tr>\n",
       "  </tbody>\n",
       "</table>\n",
       "</div>"
      ],
      "text/plain": [
       "   Row ID     Sales  Quantity  Discount    Profit  Shipping Cost\n",
       "0   32298  2309.650         7       0.0  762.1845         933.57\n",
       "1   26341  3709.395         9       0.1 -288.7650         923.63\n",
       "2   25330  5175.171         9       0.1  919.9710         915.49\n",
       "3   13524  2892.510         5       0.1  -96.5400         910.16\n",
       "4   47221  2832.960         8       0.0  311.5200         903.04"
      ]
     },
     "execution_count": 10,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "num_colms = df._get_numeric_data()\n",
    "num_colms.head()"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "9b67c396",
   "metadata": {},
   "source": [
    "###### 1. Profile the customers based on their frequency of purchase - calculate frequency of purchase for each customer and plot a histogram to get the threshold for Low/Mid/High frequency customers"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 11,
   "id": "1a91c5b0",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Row ID            51290\n",
       "Order ID          25035\n",
       "Order Date         1430\n",
       "Ship Date          1464\n",
       "Ship Mode             4\n",
       "Customer ID        1590\n",
       "Customer Name       795\n",
       "Segment               3\n",
       "City               3636\n",
       "State              1094\n",
       "Country             147\n",
       "Market                7\n",
       "Region               13\n",
       "Product ID        10292\n",
       "Category              3\n",
       "Sub-Category         17\n",
       "Product Name       3788\n",
       "Sales             22995\n",
       "Quantity             14\n",
       "Discount             27\n",
       "Profit            24575\n",
       "Shipping Cost     10037\n",
       "Order Priority        4\n",
       "dtype: int64"
      ]
     },
     "execution_count": 11,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df.nunique()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 12,
   "id": "48bcf2fa",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Customer ID    51290\n",
       "Order ID       51290\n",
       "Order Date     51290\n",
       "Ship Date      51290\n",
       "Ship Mode      51290\n",
       "Country        51290\n",
       "dtype: int64"
      ]
     },
     "execution_count": 12,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer = df[['Customer ID','Order ID','Order Date', 'Ship Date', 'Ship Mode','Country']]\n",
    "df_customer.count()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 13,
   "id": "5ce03486",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Customer ID    25754\n",
       "Order ID       25754\n",
       "Order Date     25754\n",
       "Ship Date      25754\n",
       "Ship Mode      25754\n",
       "Country        25754\n",
       "dtype: int64"
      ]
     },
     "execution_count": 13,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer1 = df[['Customer ID','Order ID','Order Date', 'Ship Date', 'Ship Mode','Country']].drop_duplicates()\n",
    "df_customer1.count()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 14,
   "id": "55552d57",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/html": [
       "<div>\n",
       "<style scoped>\n",
       "    .dataframe tbody tr th:only-of-type {\n",
       "        vertical-align: middle;\n",
       "    }\n",
       "\n",
       "    .dataframe tbody tr th {\n",
       "        vertical-align: top;\n",
       "    }\n",
       "\n",
       "    .dataframe thead th {\n",
       "        text-align: right;\n",
       "    }\n",
       "</style>\n",
       "<table border=\"1\" class=\"dataframe\">\n",
       "  <thead>\n",
       "    <tr style=\"text-align: right;\">\n",
       "      <th></th>\n",
       "      <th>Customer ID</th>\n",
       "      <th>Order ID</th>\n",
       "      <th>Order Date</th>\n",
       "      <th>Ship Date</th>\n",
       "      <th>Ship Mode</th>\n",
       "      <th>Country</th>\n",
       "    </tr>\n",
       "  </thead>\n",
       "  <tbody>\n",
       "    <tr>\n",
       "      <th>0</th>\n",
       "      <td>RH-19495</td>\n",
       "      <td>CA-2012-124891</td>\n",
       "      <td>31-07-2012</td>\n",
       "      <td>31-07-2012</td>\n",
       "      <td>Same Day</td>\n",
       "      <td>United States</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>1</th>\n",
       "      <td>JR-16210</td>\n",
       "      <td>IN-2013-77878</td>\n",
       "      <td>05-02-2013</td>\n",
       "      <td>07-02-2013</td>\n",
       "      <td>Second Class</td>\n",
       "      <td>Australia</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>2</th>\n",
       "      <td>CR-12730</td>\n",
       "      <td>IN-2013-71249</td>\n",
       "      <td>17-10-2013</td>\n",
       "      <td>18-10-2013</td>\n",
       "      <td>First Class</td>\n",
       "      <td>Australia</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>3</th>\n",
       "      <td>KM-16375</td>\n",
       "      <td>ES-2013-1579342</td>\n",
       "      <td>28-01-2013</td>\n",
       "      <td>30-01-2013</td>\n",
       "      <td>First Class</td>\n",
       "      <td>Germany</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>4</th>\n",
       "      <td>RH-9495</td>\n",
       "      <td>SG-2013-4320</td>\n",
       "      <td>05-11-2013</td>\n",
       "      <td>06-11-2013</td>\n",
       "      <td>Same Day</td>\n",
       "      <td>Senegal</td>\n",
       "    </tr>\n",
       "  </tbody>\n",
       "</table>\n",
       "</div>"
      ],
      "text/plain": [
       "  Customer ID         Order ID  Order Date   Ship Date     Ship Mode  \\\n",
       "0    RH-19495   CA-2012-124891  31-07-2012  31-07-2012      Same Day   \n",
       "1    JR-16210    IN-2013-77878  05-02-2013  07-02-2013  Second Class   \n",
       "2    CR-12730    IN-2013-71249  17-10-2013  18-10-2013   First Class   \n",
       "3    KM-16375  ES-2013-1579342  28-01-2013  30-01-2013   First Class   \n",
       "4     RH-9495     SG-2013-4320  05-11-2013  06-11-2013      Same Day   \n",
       "\n",
       "         Country  \n",
       "0  United States  \n",
       "1      Australia  \n",
       "2      Australia  \n",
       "3        Germany  \n",
       "4        Senegal  "
      ]
     },
     "execution_count": 14,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer1.head()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 15,
   "id": "74858846",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "1590"
      ]
     },
     "execution_count": 15,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer1['Customer ID'].nunique()"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "7fbeb640",
   "metadata": {},
   "source": [
    "there are only 1590 unique customer ids out of 25754 rows in the customer data"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 39,
   "id": "12ecf926",
   "metadata": {},
   "outputs": [],
   "source": [
    "#def new_features(x):\n",
    " #   d = []\n",
    "  # d.append(x['Sales'].sum()) \n",
    "   # d.append(x['Shipping Cost'].sum())\n",
    "    #d.append(pd.to_datetime(x['Order Date']).min())\n",
    "   ##d.append(x['City'].nunique())\n",
    "    #return pd.Series(d, index=['Purchases','Total_Sales','Total_Cost','First_Purchase_Date','Latest_Purchase_Date','Location_Count'])\n",
    "\n",
    "#df_customer_new = df.groupby('Customer ID').apply(new_features)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 21,
   "id": "a780b626",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Index(['Purchases', 'Total_Sales', 'Total_Cost', 'First_Purchase_Date',\n",
       "       'Latest_Purchase_Date', 'Location_Count'],\n",
       "      dtype='object')"
      ]
     },
     "execution_count": 21,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer_new.columns"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 22,
   "id": "fc5afbbf",
   "metadata": {},
   "outputs": [],
   "source": [
    "from datetime import datetime\n",
    "df_customer_new['Duration'] = (df_customer_new['Latest_Purchase_Date'] - df_customer_new['First_Purchase_Date']).dt.days"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 23,
   "id": "a7cda426",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Customer ID\n",
       "AA-10315     71.736842\n",
       "AA-10375     58.434783\n",
       "AA-10480     66.650000\n",
       "AA-10645     39.527778\n",
       "AA-315      177.285714\n",
       "Name: Frequency, dtype: float64"
      ]
     },
     "execution_count": 23,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer_new['Frequency'] = df_customer_new['Duration']/df_customer_new['Purchases']\n",
    "df_customer_new['Frequency'].head()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 24,
   "id": "44d77510",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/html": [
       "<div>\n",
       "<style scoped>\n",
       "    .dataframe tbody tr th:only-of-type {\n",
       "        vertical-align: middle;\n",
       "    }\n",
       "\n",
       "    .dataframe tbody tr th {\n",
       "        vertical-align: top;\n",
       "    }\n",
       "\n",
       "    .dataframe thead th {\n",
       "        text-align: right;\n",
       "    }\n",
       "</style>\n",
       "<table border=\"1\" class=\"dataframe\">\n",
       "  <thead>\n",
       "    <tr style=\"text-align: right;\">\n",
       "      <th></th>\n",
       "      <th>Purchases</th>\n",
       "      <th>Total_Sales</th>\n",
       "      <th>Total_Cost</th>\n",
       "      <th>First_Purchase_Date</th>\n",
       "      <th>Latest_Purchase_Date</th>\n",
       "      <th>Location_Count</th>\n",
       "      <th>Duration</th>\n",
       "      <th>Frequency</th>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>Customer ID</th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "    </tr>\n",
       "  </thead>\n",
       "  <tbody>\n",
       "    <tr>\n",
       "      <th>AA-10315</th>\n",
       "      <td>19</td>\n",
       "      <td>13747.41300</td>\n",
       "      <td>1236.15</td>\n",
       "      <td>2011-03-31</td>\n",
       "      <td>2014-12-23</td>\n",
       "      <td>18</td>\n",
       "      <td>1363</td>\n",
       "      <td>71.736842</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-10375</th>\n",
       "      <td>23</td>\n",
       "      <td>5884.19500</td>\n",
       "      <td>903.92</td>\n",
       "      <td>2011-04-21</td>\n",
       "      <td>2014-12-25</td>\n",
       "      <td>23</td>\n",
       "      <td>1344</td>\n",
       "      <td>58.434783</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-10480</th>\n",
       "      <td>20</td>\n",
       "      <td>17695.58978</td>\n",
       "      <td>1633.67</td>\n",
       "      <td>2011-01-11</td>\n",
       "      <td>2014-09-05</td>\n",
       "      <td>20</td>\n",
       "      <td>1333</td>\n",
       "      <td>66.650000</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-10645</th>\n",
       "      <td>36</td>\n",
       "      <td>15343.89070</td>\n",
       "      <td>1752.27</td>\n",
       "      <td>2011-01-12</td>\n",
       "      <td>2014-12-05</td>\n",
       "      <td>35</td>\n",
       "      <td>1423</td>\n",
       "      <td>39.527778</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-315</th>\n",
       "      <td>7</td>\n",
       "      <td>2243.25600</td>\n",
       "      <td>215.80</td>\n",
       "      <td>2011-08-06</td>\n",
       "      <td>2014-12-29</td>\n",
       "      <td>7</td>\n",
       "      <td>1241</td>\n",
       "      <td>177.285714</td>\n",
       "    </tr>\n",
       "  </tbody>\n",
       "</table>\n",
       "</div>"
      ],
      "text/plain": [
       "             Purchases  Total_Sales  Total_Cost First_Purchase_Date  \\\n",
       "Customer ID                                                           \n",
       "AA-10315            19  13747.41300     1236.15          2011-03-31   \n",
       "AA-10375            23   5884.19500      903.92          2011-04-21   \n",
       "AA-10480            20  17695.58978     1633.67          2011-01-11   \n",
       "AA-10645            36  15343.89070     1752.27          2011-01-12   \n",
       "AA-315               7   2243.25600      215.80          2011-08-06   \n",
       "\n",
       "            Latest_Purchase_Date  Location_Count  Duration   Frequency  \n",
       "Customer ID                                                             \n",
       "AA-10315              2014-12-23              18      1363   71.736842  \n",
       "AA-10375              2014-12-25              23      1344   58.434783  \n",
       "AA-10480              2014-09-05              20      1333   66.650000  \n",
       "AA-10645              2014-12-05              35      1423   39.527778  \n",
       "AA-315                2014-12-29               7      1241  177.285714  "
      ]
     },
     "execution_count": 24,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer_new.head()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 26,
   "id": "88b4cff0",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "count    1590.000000\n",
       "mean      111.303339\n",
       "std        80.489358\n",
       "min         0.000000\n",
       "25%        50.669643\n",
       "50%        73.055728\n",
       "75%       155.083333\n",
       "max       655.500000\n",
       "Name: Frequency, dtype: float64"
      ]
     },
     "execution_count": 26,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df_customer_new['Frequency'].describe()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 27,
   "id": "a9e4e5ad",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "image/png": "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\n",
      "text/plain": [
       "<Figure size 432x288 with 1 Axes>"
      ]
     },
     "metadata": {
      "needs_background": "light"
     },
     "output_type": "display_data"
    }
   ],
   "source": [
    "# 1. Profile the customers based on their frequency of purchase - calculate frequency of purchase for\n",
    "# each customer and plot a histogram to get the threshold for Low/Mid/High frequency customers\n",
    "\n",
    "plt.hist(df_customer_new['Frequency'], bins=3)\n",
    "plt.xlabel('frequency of purchase')\n",
    "plt.show()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 28,
   "id": "c076ed59",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Low     1442\n",
       "Mid      138\n",
       "High      10\n",
       "Name: freq_range, dtype: int64"
      ]
     },
     "execution_count": 28,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "# bucketing continuous data\n",
    "def freq(x):\n",
    "    if x < 219:\n",
    "        return 'Low' \n",
    "    elif x < 436:\n",
    "        return 'Mid' \n",
    "    else:\n",
    "        return 'High'\n",
    "\n",
    "df_customer_new['freq_range'] = df_customer_new.Frequency.apply(freq)\n",
    "\n",
    "df_customer_new['freq_range'].value_counts()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 29,
   "id": "b9da0ca5",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/html": [
       "<div>\n",
       "<style scoped>\n",
       "    .dataframe tbody tr th:only-of-type {\n",
       "        vertical-align: middle;\n",
       "    }\n",
       "\n",
       "    .dataframe tbody tr th {\n",
       "        vertical-align: top;\n",
       "    }\n",
       "\n",
       "    .dataframe thead th {\n",
       "        text-align: right;\n",
       "    }\n",
       "</style>\n",
       "<table border=\"1\" class=\"dataframe\">\n",
       "  <thead>\n",
       "    <tr style=\"text-align: right;\">\n",
       "      <th></th>\n",
       "      <th>Purchases</th>\n",
       "      <th>Total_Sales</th>\n",
       "      <th>Total_Cost</th>\n",
       "      <th>First_Purchase_Date</th>\n",
       "      <th>Latest_Purchase_Date</th>\n",
       "      <th>Location_Count</th>\n",
       "      <th>Duration</th>\n",
       "      <th>Frequency</th>\n",
       "      <th>freq_range</th>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>Customer ID</th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "      <th></th>\n",
       "    </tr>\n",
       "  </thead>\n",
       "  <tbody>\n",
       "    <tr>\n",
       "      <th>AA-10315</th>\n",
       "      <td>19</td>\n",
       "      <td>13747.41300</td>\n",
       "      <td>1236.15</td>\n",
       "      <td>2011-03-31</td>\n",
       "      <td>2014-12-23</td>\n",
       "      <td>18</td>\n",
       "      <td>1363</td>\n",
       "      <td>71.736842</td>\n",
       "      <td>Low</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-10375</th>\n",
       "      <td>23</td>\n",
       "      <td>5884.19500</td>\n",
       "      <td>903.92</td>\n",
       "      <td>2011-04-21</td>\n",
       "      <td>2014-12-25</td>\n",
       "      <td>23</td>\n",
       "      <td>1344</td>\n",
       "      <td>58.434783</td>\n",
       "      <td>Low</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-10480</th>\n",
       "      <td>20</td>\n",
       "      <td>17695.58978</td>\n",
       "      <td>1633.67</td>\n",
       "      <td>2011-01-11</td>\n",
       "      <td>2014-09-05</td>\n",
       "      <td>20</td>\n",
       "      <td>1333</td>\n",
       "      <td>66.650000</td>\n",
       "      <td>Low</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-10645</th>\n",
       "      <td>36</td>\n",
       "      <td>15343.89070</td>\n",
       "      <td>1752.27</td>\n",
       "      <td>2011-01-12</td>\n",
       "      <td>2014-12-05</td>\n",
       "      <td>35</td>\n",
       "      <td>1423</td>\n",
       "      <td>39.527778</td>\n",
       "      <td>Low</td>\n",
       "    </tr>\n",
       "    <tr>\n",
       "      <th>AA-315</th>\n",
       "      <td>7</td>\n",
       "      <td>2243.25600</td>\n",
       "      <td>215.80</td>\n",
       "      <td>2011-08-06</td>\n",
       "      <td>2014-12-29</td>\n",
       "      <td>7</td>\n",
       "      <td>1241</td>\n",
       "      <td>177.285714</td>\n",
       "      <td>Low</td>\n",
       "    </tr>\n",
       "  </tbody>\n",
       "</table>\n",
       "</div>"
      ],
      "text/plain": [
       "             Purchases  Total_Sales  Total_Cost First_Purchase_Date  \\\n",
       "Customer ID                                                           \n",
       "AA-10315            19  13747.41300     1236.15          2011-03-31   \n",
       "AA-10375            23   5884.19500      903.92          2011-04-21   \n",
       "AA-10480            20  17695.58978     1633.67          2011-01-11   \n",
       "AA-10645            36  15343.89070     1752.27          2011-01-12   \n",
       "AA-315               7   2243.25600      215.80          2011-08-06   \n",
       "\n",
       "            Latest_Purchase_Date  Location_Count  Duration   Frequency  \\\n",
       "Customer ID                                                              \n",
       "AA-10315              2014-12-23              18      1363   71.736842   \n",
       "AA-10375              2014-12-25              23      1344   58.434783   \n",
       "AA-10480              2014-09-05              20      1333   66.650000   \n",
       "AA-10645              2014-12-05              35      1423   39.527778   \n",
       "AA-315                2014-12-29               7      1241  177.285714   \n",
       "\n",
       "            freq_range  \n",
       "Customer ID             \n",
       "AA-10315           Low  \n",
       "AA-10375           Low  \n",
       "AA-10480           Low  \n",
       "AA-10645           Low  \n",
       "AA-315             Low  "
      ]
     },
     "execution_count": 29,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "# profiling based on purchase frequency\n",
    "df_customer_new.head()"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "d224c3cb",
   "metadata": {},
   "source": [
    "2.Are the high frequent customers contributing more revenue"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 32,
   "id": "6594a521",
   "metadata": {},
   "outputs": [],
   "source": [
    "import numpy as np\n",
    "result = df.groupby([\"Customer Name\"])['Profit'].aggregate(np.sum).reset_index().sort_values('Profit',ascending = False).head(20)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 33,
   "id": "effa8263",
   "metadata": {},
   "outputs": [],
   "source": [
    "df_customer_new['Revenue'] = df_customer_new['Purchases'] *  df_customer_new['Total_Sales']"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 34,
   "id": "3a03d92c",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "image/png": "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\n",
      "text/plain": [
       "<Figure size 360x360 with 1 Axes>"
      ]
     },
     "metadata": {
      "needs_background": "light"
     },
     "output_type": "display_data"
    }
   ],
   "source": [
    "sns.catplot(x=\"freq_range\", y=\"Revenue\", kind=\"bar\", data=df_customer_new);"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "9d46ab11",
   "metadata": {},
   "source": [
    "From the graph we can see that the high frequent customers are contrinuting less\n",
    "\n",
    "1.Are they also profitable - what is the profit margin across the buckets"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 35,
   "id": "9af30e97",
   "metadata": {},
   "outputs": [],
   "source": [
    "profit_margin = df_customer_new.groupby('freq_range')"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 36,
   "id": "4838b34e",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "<pandas.core.groupby.generic.DataFrameGroupBy object at 0x000001A31BB8F730>"
      ]
     },
     "execution_count": 36,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "profit_margin"
   ]
  },
  {
   "cell_type": "markdown",
   "id": "af4d4e1c",
   "metadata": {},
   "source": [
    "4. Which customer segment is most profitable in each year ( there is a column called customer segment)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 37,
   "id": "8eb744bd",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "Consumer       26518\n",
       "Corporate      15429\n",
       "Home Office     9343\n",
       "Name: Segment, dtype: int64"
      ]
     },
     "execution_count": 37,
     "metadata": {},
     "output_type": "execute_result"
    }
   ],
   "source": [
    "df.Segment.value_counts()"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": 38,
   "id": "b3b981e9",
   "metadata": {},
   "outputs": [
    {
     "data": {
      "text/plain": [
       "<AxesSubplot:xlabel='Segment', ylabel='count'>"
      ]
     },
     "execution_count": 38,
     "metadata": {},
     "output_type": "execute_result"
    },
    {
     "data": {
      "image/png": "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\n",
      "text/plain": [
       "<Figure size 432x288 with 1 Axes>"
      ]
     },
     "metadata": {
      "needs_background": "light"
     },
     "output_type": "display_data"
    }
   ],
   "source": [
    "sns.countplot(x=\"Segment\",data = df)"
   ]
  },
  {
   "cell_type": "code",
   "execution_count": null,
   "id": "ecd53c42",
   "metadata": {},
   "outputs": [],
   "source": []
  }
 ],
 "metadata": {
  "kernelspec": {
   "display_name": "Python 3 (ipykernel)",
   "language": "python",
   "name": "python3"
  },
  "language_info": {
   "codemirror_mode": {
    "name": "ipython",
    "version": 3
   },
   "file_extension": ".py",
   "mimetype": "text/x-python",
   "name": "python",
   "nbconvert_exporter": "python",
   "pygments_lexer": "ipython3",
   "version": "3.9.12"
  }
 },
 "nbformat": 4,
 "nbformat_minor": 5
}
