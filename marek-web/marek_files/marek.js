(function(l){
	l.module("treeView",[])
	.directive(
		"treeModel",
		function($compile){
			return {
				restrict:"A",
				link:function(scope,element,attrs) {
					var tree = attrs.treeModel,
					name = attrs.nodeName,
					nodes = attrs.nodeNodes,
					ulHTML =
'<ul>'+
	'<li data-ng-repeat="node in ' + tree + '">' +
		'<i class="collapsed" data-ng-show="node.' + nodes + '.length && node.collapsed" data-ng-click="selectNodeHead(node, $event)"></i>' +
		'<i class="expanded" data-ng-show="node.' + nodes + '.length && !node.collapsed" data-ng-click="selectNodeHead(node, $event)"></i>' +
		'<i class="normal" data-ng-hide="node.' + nodes + '.length"></i>'+
		'<span data-ng-class="node.selected" data-ng-click="selectNodeLabel(node, $event)">{{node.' + name + '}}</span>' +
		'<div data-ng-hide="node.collapsed" data-tree-model="node.' + nodes + '" data-node-id=' + (attrs.nodeId||"id") + " data-node-name="+name+" data-node-nodes="+nodes+'></div>'+
	'</li>'+
'</ul>';
					tree&&tree.length&&(
					  scope.$watch(tree,function(m,b){element.empty().html($compile(ulHTML)(scope))},!1),
					  scope.selectNodeHead = scope.selectNodeHead || function(scope,event) {
						scope.collapsed = !scope.collapsed
					  },
					  scope.selectNodeLabel = scope.selectNodeLabel || function(node,event) {
						scope.currentNode && scope.currentNode.selected && (scope.currentNode.selected=void 0);
						node.selected = "selected";
						scope.currentNode = node
					  }
					)
				}
			}
		}
	)
})(angular);