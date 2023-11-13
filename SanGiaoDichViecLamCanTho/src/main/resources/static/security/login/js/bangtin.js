const app = angular.module('bangtin-app', []);
app.controller('giave-ctrl', function($scope, $http) {
	$scope.items = [],
		$scope.initialize = function() {
			$http.get("/rest/bangtin").then(response => {
				$scope.items = response.data;
				$scope.post = true
				$scope.put = false
				$scope.delete = false
			})

		}

	$scope.initialize()
$scope.display = function(){
	
}
	$scope.pager = {
		page: 0,
		size: 4,
		get items() {
			var start = this.page * this.size;
			return $scope.items.bangtin.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.items.giave.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		last() {
			this.page = this.count - 1;
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		}
	}

})