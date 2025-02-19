#include<iostream>
#include<conio.h>
#include<time.h>

using namespace std;

int CalculateOutput(double w[], double x, double y);

int main(){
	const int n = 4;
	int maxiteration = 400;
	double learning_rate = 0.1;


	srand(time(NULL));
	double x[n], y[n], w[3], localerror, globalerror;
	int iteration = 0, out[n], output;

	w[0] = 3;//((double)rand() / (RAND_MAX));
	w[1] = 3;// ((double)rand() / (RAND_MAX));
	w[2] = 3;// ((double)rand() / (RAND_MAX));

	cout << w[0] << " " << w[1] << " " << w[2] << endl;

	x[0] = 1;
	x[1] = 1;
	x[2] = 0;
	x[3] = 0;

	y[0] = 0;
	y[1] = 1;
	y[2] = 0;
	y[3] = 1;

	out[0] = 0;
	out[1] = 1;
	out[2] = 0;
	out[3] = 0;

	do {
		int hits = 0;
		iteration++;
		globalerror = 0;
		for (int i = 0; i < n; i++) {
			output = CalculateOutput(w, x[i], y[i]);
			if (output == out[i]) hits++;

			localerror = out[i] - output;
			w[0] += localerror * learning_rate * x[i];
			w[1] += localerror * learning_rate * y[i];
			w[2] += learning_rate * localerror;
			globalerror += (localerror*localerror);
		}
		cout << "Stopa trafien w generacji : " << ((double) hits / n) * 100 << "%" << endl;
	} while (globalerror != 0 && iteration < maxiteration);


	cout << "Ilosc iteracji: " << iteration << endl;
	cout << "Koncowe rownanie: " << w[0] << "*x + " << w[1] << "*y + " << w[2] << " = 0" << endl << endl;

	system("pause");
	return 0;
}

int CalculateOutput(double w[], double x, double y){
	double sum = x*w[0] + y*w[1] + w[2];
	return (sum >= 0) ? 1 : 0;
}