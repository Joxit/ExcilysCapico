/**
 * Created by Joxit on 18/06/15.
 */

angular.module('angular')
    .controller('TweetsCtrl', function ($scope, $http) {
        $http.get("http://192.168.11.41:8080/tweets", {timeout: 100
        }).success(function (data, status, headers, config) {
            $scope.messages = data;
        });
        $scope.post = function () {
            if ($scope.inputMessage && $scope.inputMessage.length < 141 && $scope.name && $scope.email) {
                var outputMessage = {authorEmail: $scope.email, authorName: "@"+$scope.name, message: $scope.inputMessage};
                console.log(outputMessage);
                $http.post("http://192.168.11.41:8080/tweets", outputMessage)
            }
        };
        $scope.showReply = function (id){

        }

        $scope.timestampToRelativeDate = function (timestamp){
            return moment(timestamp).fromNow();
        }
    });
