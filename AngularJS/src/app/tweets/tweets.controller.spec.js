/**
 * Created by Joxi<md-button href="https://github.com/Swiip/generator-gulp-angular">Gulp Angular</md-button>

  <section flex layout="row" layout-align="left center">
    <md-button href="#" class="md-raised">Home</md-button>
    <md-button href="#" class="md-raised">About</md-button>
    <md-button href="#" class="md-raised">Contact</md-button>
  </section>

  <md-button href="#">Current date: {{ date | date:'yyyy-MM-dd' }}</md-button>t on 18/06/15.
 */
'use strict';

describe('controllers', function(){
    var scope;

    beforeEach(module('angular'));

    beforeEach(inject(function($rootScope) {
        scope = $rootScope.$new();
    }));

    it('should define more than 5 awesome things', inject(function($controller) {
        expect(scope.awesomeThings).toBeUndefined();

        $controller('TweetsCtrl', {
            $scope: scope
        });

        expect(angular.isArray(scope.awesomeThings)).toBeTruthy();
        expect(scope.awesomeThings.length > 5).toBeTruthy();
    }));
});
